package com.heytusar.hellospring.repository;

import java.util.List;

import org.json.JSONObject;

import com.heytusar.hellospring.models.Person;

public interface PersonRepositoryCustom {
	Person savePerson(JSONObject json);
	List<Person> findAll();
}
