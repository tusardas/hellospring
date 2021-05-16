package com.heytusar.hellospring.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heytusar.hellospring.service.PersonService;

@RestController
public class PersonController {
	
private static final Logger log = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value="/person", method = RequestMethod.POST)
	public ResponseEntity<Map> savePerson(@RequestBody String jsonBody) throws Exception {
		Map models = personService.savePerson(jsonBody);
		return new ResponseEntity<Map>(models, HttpStatus.OK);
	}
	
	@RequestMapping(value="/person/{personId}", method = RequestMethod.GET)
	public ResponseEntity<Map> getPerson(@PathVariable Long personId) throws Exception {
		Map models = personService.getPersonById(personId);
		return new ResponseEntity<Map>(models, HttpStatus.OK);
	}
	
	@RequestMapping(value="/person", method = RequestMethod.GET)
	public ResponseEntity<Map> getAllPerson() throws Exception {
		Map models = personService.getAllPerson();
		return new ResponseEntity<Map>(models, HttpStatus.OK);
	}
}
