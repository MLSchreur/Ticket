package nl.ticket.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	public String getFirstName() {
		return firstName;
	}
	/* =================================================================== */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/* =================================================================== */
	public String getLastName() {
		return lastName;
	}
	/* =================================================================== */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/* =================================================================== */
	public String getEmail() {
		return email;
	}
	/* =================================================================== */
	public void seteMail(String email) {
		this.email = email;
	}
	/* =================================================================== */
	public long getId() {
		return id;
	}
}
