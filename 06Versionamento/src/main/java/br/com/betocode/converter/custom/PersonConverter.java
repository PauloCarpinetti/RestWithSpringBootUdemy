package br.com.betocode.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.betocode.data.model.Person;
import br.com.betocode.data.vo.v2.PersonVOV2;

@Service
public class PersonConverter {

	public PersonVOV2 convertEntityToVO(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setEndereco(person.getEndereco());
		vo.setNascimento(new Date());
		vo.setPrimeiroNome(person.getPrimeiroNome());
		vo.setUltimoNome(person.getUltimoNome());
		vo.setGenero(person.getGenero());
		return vo;
	}	
	
	public Person convertVOToEntity(PersonVOV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setEndereco(person.getEndereco());
		entity.setPrimeiroNome(person.getPrimeiroNome());
		entity.setUltimoNome(person.getUltimoNome());
		entity.setGenero(person.getGenero());
		return entity;
	}

}
