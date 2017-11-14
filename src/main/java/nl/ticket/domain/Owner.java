package nl.ticket.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Owner extends Person {
	
	@OneToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Ticket> tickets = new ArrayList<Ticket>();
	
	public boolean isLinkedTicket(Ticket linkedTicket) {
		for (Ticket ticket : tickets) {
			if (ticket.getId() == linkedTicket.getId()) {
				return true;
			}
		}
		return false;
	}
	
	public void addTicket(Ticket ticket){
		this.tickets.add(ticket);
	}

	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	public List<Ticket> getTickets() {
		return tickets;
	}
	/* =================================================================== */
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
}
