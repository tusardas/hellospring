package com.heytusar.hellospring.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.json.JSONObject;

import com.heytusar.hellospring.models.Person;


public class PersonRepositoryImpl {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Person savePerson(JSONObject json) {
		Person person = new Person();
		person.setFirstName(json.getString("firstName"));
		person.setLastName(json.getString("lastName"));
		entityManager.persist(person);
		return person;
	}
}
