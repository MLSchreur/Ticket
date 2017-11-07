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

import nl.ticket.domain.Owner;
import nl.ticket.persistence.OwnerService;

@Path("owner")
@Component
public class OwnerEndpoint {
	
	@Autowired
	private OwnerService ownerService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listOwner(){
		System.out.println("Got the OWNER list!");
		Iterable <Owner> result = ownerService.findAll();
		return Response.ok(result).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postOwner(Owner owner){
		System.out.println("Posted: " + owner.getFirstName() + " " + owner.getLastName());
		ownerService.save(owner);
		return Response.accepted(owner).build();
	}
}
