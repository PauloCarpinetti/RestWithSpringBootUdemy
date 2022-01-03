package br.com.betocode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.betocode.exception.ResourceNotFoundException;
import br.com.betocode.model.Person;
import br.com.betocode.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public List<Person> findAll(){
		return repository.findAll();
    }
	
	public Person FindById(Long id) {
		
		return repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Sem registro para este Id."));
	}
	
	public Person update(Person person) {	
		Person entity = repository.findById(person.getId()).orElseThrow(
				() -> new ResourceNotFoundException("Sem registro para este Id."));
		entity.setPrimeiroNome(person.getPrimeiroNome());
		entity.setUltimoNome(person.getUltimoNome());	
		entity.setEndereco(person.getEndereco());
		entity.setGenero(person.getGenero());
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Sem registro para este Id."));
		repository.delete(entity);
	}
	
	
		
	
}

	
	
	

