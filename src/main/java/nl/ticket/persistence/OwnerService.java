package nl.ticket.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.ticket.domain.Owner;

@Service
@Transactional
public class OwnerService {
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	public Iterable <Owner> findAll(){
		Iterable<Owner> result = ownerRepository.findAll();
		return result;
	}
	
	public void save(Owner owner){
		ownerRepository.save(owner);
	}
}
