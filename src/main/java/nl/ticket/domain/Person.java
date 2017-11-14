package nl.ticket.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false)
	private String firstName;
	private String insertion;
	@Column(nullable=false)
	private String lastName;
	
	private String email;
	
	@Column(unique=true, nullable=false)
	private String username;
	private String password;
	
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
	public String getInsertion() {
		return insertion;
	}
	/* =================================================================== */
	public void setInsertion(String insertion) {
		this.insertion = insertion;
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
	/* =================================================================== */
	public String getUsername() {
		return username;
	}
	/* =================================================================== */
	public void setUsername(String username) {
		this.username = username;
	}
	/* =================================================================== */
	public String getPassword() {
		return password;
	}
	/* =================================================================== */
	public void setPassword(String password) {
		this.password = password;
	}
}
