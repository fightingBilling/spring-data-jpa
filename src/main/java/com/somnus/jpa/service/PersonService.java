package com.somnus.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.somnus.jpa.model.Person;
import com.somnus.jpa.repositories.PersonRepsotory;

@Service
public class PersonService {

	@Autowired
	private PersonRepsotory personRepsotory;
	
	@Transactional
	public void savePersons(List<Person> persons){
		personRepsotory.save(persons);
	}
	
	@Transactional
	public void updatePersonEmail(String email, Integer id){
		personRepsotory.updatePersonEmail(id, email);
	}
}
