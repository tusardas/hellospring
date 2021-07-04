package com.heytusar.hellospring.service;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.heytusar.hellospring.models.Person;
import com.heytusar.hellospring.repository.PersonRepository;



@Service
@Transactional
public class PersonService {
	private static final Logger log = LoggerFactory.getLogger(PersonService.class);
	
	private PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public Map<String, Object> savePerson(String jsonBody) {
		JSONObject json = new JSONObject(jsonBody);
		Person person = personRepository.savePerson(json);
		Map<String, Object> models = new HashMap<String, Object>();
		models.put("person", person);
		return models;
	}

	public Map getPersonById(Long personId) {
		Person person = personRepository.findById(personId).orElse(null);
		if(person == null) {
			throw new ResponseStatusException(
			  HttpStatus.NO_CONTENT, "No person found"
			);
		}
		Map<String, Object> models = new HashMap<String, Object>();
		models.put("person", person);
		return models;
	}

	public Map getAllPerson() {
		Iterable<Person> list = personRepository.findAll();
		Map<String, Object> models = new HashMap<String, Object>();
		models.put("persons", list);
		return models;
	}
}
