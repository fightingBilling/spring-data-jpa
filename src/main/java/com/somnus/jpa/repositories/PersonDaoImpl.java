package com.somnus.jpa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.somnus.jpa.model.Person;

public class PersonDaoImpl implements PersonDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void test() {
		Person person = entityManager.find(Person.class, 11);
		System.out.println("-->" + person);
	}

}
