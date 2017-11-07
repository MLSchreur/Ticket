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

import nl.ticket.domain.Event;
import nl.ticket.persistence.EventService;

@Path("event")
@Component
public class EventEndpoint {
	
	@Autowired
	private EventService eventService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listEvent(){
		System.out.println("Got the EVENT list!");
		Iterable <Event> result = eventService.findAll();
		return Response.ok(result).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postEvent(Event event){
		System.out.println("Posted: " + event.getTitle() + " " + event.getDate());
		eventService.save(event);
		return Response.accepted(event).build();
	}
}
