package nl.ticket.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.ticket.domain.Owner;
import nl.ticket.persistence.OwnerService;

@Path("owner")
@Component
public class OwnerEndpoint {
	
	@Autowired
	private OwnerService ownerService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postOwner(Owner owner){
		System.out.println("Posted: " + owner.getFirstName()
			+ "." + owner.getInsertion() + "." + owner.getLastName());
		Owner result = ownerService.save(owner);
		return Response.accepted(result).build();
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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listOwner(){
		System.out.println("Got the OWNER list!");
		Iterable <Owner> result = ownerService.findAll();
		return Response.ok(result).build();
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
}
