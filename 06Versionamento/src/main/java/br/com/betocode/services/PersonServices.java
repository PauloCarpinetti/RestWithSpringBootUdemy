package br.com.betocode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.betocode.converter.DozerConverter;
import br.com.betocode.converter.custom.PersonConverter;
import br.com.betocode.data.model.Person;
import br.com.betocode.data.vo.PersonVO;
import br.com.betocode.data.vo.v2.PersonVOV2;
import br.com.betocode.exception.ResourceNotFoundException;
import br.com.betocode.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonConverter converter;
	
	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		var entity = converter.convertVOToEntity(person);
		var vo = converter.convertEntityToVO(repository.save(entity));
		return vo;
	}
	
	public List<PersonVO> findAll(){
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
    }
	
	public PersonVO FindById(Long id) {
		
		var entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Sem registro para este Id."));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO update(PersonVO person) {	
		var entity = repository.findById(person.getId()).orElseThrow(
				() -> new ResourceNotFoundException("Sem registro para este Id."));
		entity.setPrimeiroNome(person.getPrimeiroNome());
		entity.setUltimoNome(person.getUltimoNome());	
		entity.setEndereco(person.getEndereco());
		entity.setGenero(person.getGenero());
		
		var vo = DozerConverter.parseObject(entity, PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Sem registro para este Id."));
		repository.delete(entity);
	}
	
}

	
	
	

