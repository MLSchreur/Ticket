package nl.ticket.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	
	private Date date;
	
	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	
	public String getTitle() {
		return title;
	}
	/* =================================================================== */
	public void setTitle(String title) {
		this.title = title;
	}
	/* =================================================================== */
	public Date getDate() {
		return date;
	}
	/* =================================================================== */
	public void setDate(Date date) {
		this.date = date;
	}
	/* =================================================================== */
	public long getId() {
		return id;
	}
}
