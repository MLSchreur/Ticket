package nl.ticket.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.ticket.domain.Ticket;

@Service
@Transactional
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	public Iterable <Ticket> findAll(){
		Iterable<Ticket> result = ticketRepository.findAll();
		return result;
	}
	
	public void save(Ticket ticket){
		ticketRepository.save(ticket);
	}

	public Ticket findById(Long ticketId) {
		return ticketRepository.findOne(ticketId);
	}
}
