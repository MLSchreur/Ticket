package nl.ticket.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.ticket.domain.Owner;

@Component
public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
