package nl.ticket.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.ticket.domain.Event;

@Service
@Transactional
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	public Iterable <Event> findAll(){
		Iterable<Event> result = eventRepository.findAll();
		return result;
	}
	
	public void save(Event event){
		eventRepository.save(event);
	}
}
