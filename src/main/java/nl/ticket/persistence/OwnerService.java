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
	
	public Owner save(Owner owner){
		return ownerRepository.save(owner);
	}

	public Owner findById(Long id) {
		return ownerRepository.findOne(id);
	}

	public void deleteById(Long id) {
		ownerRepository.delete(id);
	}
}
