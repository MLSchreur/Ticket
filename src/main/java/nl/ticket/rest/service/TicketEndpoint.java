package nl.ticket.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.ticket.domain.Ticket;
import nl.ticket.persistence.TicketService;

@Path("ticket")
@Component
public class TicketEndpoint {
	
	@Autowired
	private TicketService ticketService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listTicket(){
		System.out.println("Got the TICKET list!");
		Iterable<Ticket> result = ticketService.findAll();
		return Response.ok(result).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postTicket(Ticket ticket){
		System.out.println("Posted: " + ticket.getBarCode() + " " + ticket.getPrice());
		ticketService.save(ticket);
		return Response.accepted(ticket).build();
	}

}
