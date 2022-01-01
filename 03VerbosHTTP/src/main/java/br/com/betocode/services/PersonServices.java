package br.com.betocode.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.betocode.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		
	}
	
	public Person FindById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setPrimeiroNome("Paulo");
		person.setUltimoNome("Carpinetti");	
		person.setEndereco("São - Paulo SP - Brasil");
		person.setGenero("masculino");
		return person ;
	}
		
	public List<Person> findAll(){
		List<Person> persons = new ArrayList<Person>();
		for (int i=0; i<8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setPrimeiroNome("Nome" + i);
		person.setUltimoNome("Sobrenome" +i);	
		person.setEndereco("São - Paulo SP - Brasil");
		person.setGenero("masculino");
		return person ;
	}
	
	
}
