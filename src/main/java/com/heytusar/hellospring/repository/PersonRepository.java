package com.heytusar.hellospring.repository;

import org.springframework.data.repository.CrudRepository;

import com.heytusar.hellospring.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long>, PersonRepositoryCustom {

}
