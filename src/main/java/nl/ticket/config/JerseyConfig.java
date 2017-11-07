package nl.ticket.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import nl.ticket.rest.service.EventEndpoint;
import nl.ticket.rest.service.OwnerEndpoint;
import nl.ticket.rest.service.TekstEndpoint;
import nl.ticket.rest.service.TicketEndpoint;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig(){
		register(TekstEndpoint.class);
		register(OwnerEndpoint.class);
		register(TicketEndpoint.class);
		register(EventEndpoint.class);
	}
}
