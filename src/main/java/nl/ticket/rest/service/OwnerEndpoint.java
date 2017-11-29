package nl.ticket.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.ticket.domain.Owner;
import nl.ticket.domain.Ticket;
import nl.ticket.persistence.OwnerService;
import nl.ticket.persistence.PersonService;
import nl.ticket.persistence.TicketService;

@Path("owner")
@Component
public class OwnerEndpoint {
	
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private PersonService personService;
	
	/**
	 * Aanmaken van nieuwe owner
	 * @param	owner Cre&euml;ren van een nieuwe Owner.
	 * @return 	Code 202 (Accepted)<br>
	 * 			Code 406 (Not acceptable) - 1 = heeft al een id<br>
	 * 			Code 406 (Not acceptable) - 2 = gegevens niet goed ingevuld<br>
	 * 			Code 406 (Not acceptable) - 3 = gebruikersnaam bestaat al
	 */	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postOwner(Owner owner){
		int personCheck = personService.postPerson(owner);
		switch(personCheck){
		case 0:
			ownerService.save(owner);
			System.out.println("Posted: " + owner.getFirstName()
			+ "." + owner.getInsertion() + "." + owner.getLastName());
			return Response.accepted().build();
		case 1:
			System.out.println("Heeft al een id");
			return Response.status(406).entity(1).build();
		case 2:
			System.out.println("Ontbrekende gegevens");
			return Response.status(406).entity(2).build();
		case 3:
			System.out.println("Gebruikersnaam bestaat al");
			return Response.status(406).entity(3).build();
		default:
			System.out.println("Onbekende return");
			return Response.status(406).build();
		}
	}
	
	/**
	 * Opvragen van de owner.
	 * Op basis van id worden de gegevens gefilterd via een JSON object teruggegeven.
	 * @param 	id 	Id van het Owner wordt uit het path gehaald.
	 * @return 	Code 200 (OK)<br>
	 * 		 	Code 204 (No Content)<br>
	 * 			Opgevraagde owner wordt (zonder wachtwoord) als JSON object teruggegeven.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getOwnerById(@PathParam("id") Long id) {
		Owner result = this.ownerService.findById(id);
		if (result != null) {
			return Response.ok(result).build();
		} else {
			return Response.noContent().build();
		}
	}
	
	/**
	 * Opvragen van alle owners.
	 * @return 	Code 200 (OK)<br>
	 * 			Code 204 (No Content)<br>
	 * 			Alle owners (zonder wactwoord) worden als JSON objecten teruggegeven.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listOwner(){
		Iterable <Owner> result = ownerService.findAll();
		if(result != null){
			System.out.println("Got the OWNER list!");
			return Response.ok(result).build();
		} else {
			return Response.noContent().build();
		}
	}
	
	/**
	 * Verwijderen van de opgegeven Owner (id) inclusief de koppelingen met de tickets.
	 * @param 	id 	Id van de te verwijderen Owner wordt uit het path gehaald.
	 * @return 	Code 202 (Accepted)<br>
	 * 		 	Code 204 (No Content)
	 */	
	@DELETE
	@Path("{id}")
	public Response deleteOwnerById(@PathParam("id") Long id){
		Owner owner = ownerService.findById(id);
		if(owner != null){
			ownerService.deleteById(id);
			return Response.accepted().build();
		} else {
			return Response.noContent().build();
		}
	}
	
	/**
	 * Aanmaken van koppeling tussen Ticket(id) met Owner (id).
	 * @param 	id 					Id van de Owner waar een Ticket aan toegevoegd moet worden.
	 * @param	ticketId			Ticket die toegevoegd moet worden aan Owner (id).
	 * @return 	0 = Owner en Ticket zijn gekoppeld<br>
	 * 		 	1 = Owner met opgegeven id bestaat niet.<br>
	 * 		 	2 = Ticket met opgegeven id bestaat niet.<br>
	 * 		 	3 = Ticket met opgegeven id is al gekoppeld aan de Owner.
	 */
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{id}/ticket/{ticket_id}")
	public Response addTicketToOwner(@PathParam("id") Long id, @PathParam("ticket_id") Long ticketId) {
		Owner owner = ownerService.findById(id);
		if(owner != null){
			Ticket ticket = ticketService.findById(ticketId);
			if(ticket != null){
				if(!owner.isLinkedTicket(ticket)){
					owner.addTicket(ticket);
					System.out.println(owner.getId());
					ownerService.save(owner);
					return Response.accepted().build();
				} else {
					return Response.status(406).entity("3").build();
				}
			} else {
				return Response.status(406).entity("2").build();
			}
		} else {
			return Response.status(406).entity("1").build();
		}
	}
}
