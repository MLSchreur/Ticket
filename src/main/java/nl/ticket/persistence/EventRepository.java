package nl.ticket.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.ticket.domain.Event;

@Component
public interface EventRepository extends CrudRepository<Event, Long> {

}
