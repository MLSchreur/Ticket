package nl.ticket.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.ticket.domain.Tekst;

@Component
public interface TekstRepository extends CrudRepository <Tekst, Long>{

}
