package nl.ticket.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.ticket.domain.Ticket;

@Component
public interface TicketRepository extends CrudRepository<Ticket, Long> {

}
