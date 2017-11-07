package nl.ticket.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Bestemd voor 1e test tijdens ontwikkeling
 * @author Marcel Schreur
 * @version 0.1.0
 * @since 2017-07-17
 */

@Entity
public class Tekst {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String tekst;

	public long getId() {
		return id;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

}
