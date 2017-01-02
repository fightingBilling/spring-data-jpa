package com.somnus.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.jpa.model.Person;
import com.somnus.jpa.repositories.PersonCrudRepsotory;

public class SpringTest2 extends AbstractTestSupport{
	
	@Test
	public void testCrudReposiory(){
		List<Person> persons = new ArrayList<>();
		
		for(int i = 'a'; i <= 'z'; i++){
			Person person = new Person();
			person.setAddressId(i + 1);
			person.setBirth(new Date());
			person.setEmail((char)i + "" + (char)i + "@atguigu.com");
			person.setLastName((char)i + "" + (char)i);
			
			persons.add(person);
		}
		PersonCrudRepsotory repsotory = ApplicationContextHolder.getBean(PersonCrudRepsotory.class);
		repsotory.save(persons);
	}
	
	@Test
	public void testModifying(){
		PersonCrudRepsotory repsotory = ApplicationContextHolder.getBean(PersonCrudRepsotory.class);
		repsotory.updatePersonEmail(1,"mmmm@atguigu.com");
	}
	
}
