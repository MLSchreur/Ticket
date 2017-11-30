package nl.ticket.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.ticket.domain.Owner;
import nl.ticket.domain.Person;

@Service
@Transactional
public class PersonService {
	
	@Autowired
	private OwnerService ownerService;
	
	/**
	 * Aanmaken van nieuwe gebruiker
	 * @param	person Cre&euml;ren van een nieuwe gebruiker.
	 * @return 	0 = gebruiker kan worden opgeslagen
	 * 			1 = heeft al een id<br>
	 * 			2 = gegevens niet goed ingevuld<br>
	 * 			3 = gebruikersnaam bestaat al
	 */

	public int postPerson(Person person){
		if(person.getId() != 0) {
			System.out.println("Heeft al een id");
			return 1;
		} else if (person.getLastName() == null || person.getFirstName() == null || person.getUsername() == null) {
			System.out.println("Niet alles ingevuld");
			return 2;
		}
		List<Person> persons = new ArrayList<>();
		persons.addAll((ArrayList<Owner>)ownerService.findAll());
		if(persons.size() != 0){
			for(Person prsn: persons){
				if(prsn.getUsername().equalsIgnoreCase(person.getUsername())){
					System.out.println(person.getUsername() + " bestaat al!");
					return 3;
				}
			}
		}
		System.out.println("Gebruiker kan worden opgeslagen");
		return 0;
	}
	
	/**
	 * Controle of gebruikersnaam bestaat
	 * @param validatePerson De te valideren gebruiker
	 * @return 	0   = gebruikersnaam bestaat niet
	 * 			1 	= gebruiker is docent
	 * 			2	= gebruiker is leerling
	 */
	public Person checkUserName(Person validatePerson){
		List<Person> persons = new ArrayList<>();
		persons.addAll((ArrayList<Owner>)ownerService.findAll());
		for(Person person: persons){
			if(validatePerson.getUsername().equalsIgnoreCase(person.getUsername())){
				return person;
			}
		}
		return null;
	}
}
