package br.com.betocode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.betocode.converter.DozerConverter;
import br.com.betocode.data.model.Person;
import br.com.betocode.data.vo.PersonVO;
import br.com.betocode.exception.ResourceNotFoundException;
import br.com.betocode.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
	
	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public Page<PersonVO> findPersonByName(String firstName, Pageable pageable){
		var page = repository.findPersonByName(firstName, pageable);
		return page.map(this::ConvertToPersonVO);
    }
	
	public Page<PersonVO> findAll(Pageable pageable){
		var page = repository.findAll(pageable);
		return page.map(this::ConvertToPersonVO);
    }
	
	public PersonVO ConvertToPersonVO(Person entity) {
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
		
	public PersonVO findById(Long id) {
		
		var entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Sem registro para este Id."));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO update(PersonVO person) {	
		var entity = repository.findById(person.getKey()).orElseThrow(
				() -> new ResourceNotFoundException("Sem registro para este Id."));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());	
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerConverter.parseObject(entity, PersonVO.class);
		return vo;
	}
	
	@Transactional
	public PersonVO disablePerson(Long id) {
		
		repository.disablePersons(id);
		var entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Sem registro para este Id."));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	@Transactional
	public PersonVO enablePerson(Long id) {
		
		repository.enablePersons(id);
		var entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Sem registro para este Id."));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Sem registro para este Id."));
		repository.delete(entity);
	}
	
}