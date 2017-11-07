package nl.ticket.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double price;
	
	private double barCode;
	
	private String info;
	
	@OneToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List <Event> event = new ArrayList<Event>();

	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	public double getPrice() {
		return price;
	}
	/* =================================================================== */
	public void setPrice(double price) {
		this.price = price;
	}
	/* =================================================================== */
	public double getBarCode() {
		return barCode;
	}
	/* =================================================================== */
	public void setBarCode(double barCode) {
		this.barCode = barCode;
	}
	/* =================================================================== */
	public String getInfo() {
		return info;
	}
	/* =================================================================== */
	public void setInfo(String info) {
		this.info = info;
	}
	/* =================================================================== */
	public List<Event> getEvents() {
		return event;
	}
	/* =================================================================== */
	public void setEvents(List<Event> event) {
		this.event = event;
	}
	/* =================================================================== */
	public long getId() {
		return id;
	}
}
