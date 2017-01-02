package com.somnus.jpa;

import java.util.Date;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.jpa.model.Person;
import com.somnus.jpa.repositories.PersonJpaRepsotory;

public class SpringTest4 extends AbstractTestSupport{
	
	@Test
	public void testJpaRepository(){
		Person person = new Person();
		person.setBirth(new Date());
		person.setEmail("xy@atguigu.com");
		person.setLastName("xyz");
		person.setId(28);
		
		PersonJpaRepsotory repsotory = ApplicationContextHolder.getBean(PersonJpaRepsotory.class);
		
		Person person2 = repsotory.saveAndFlush(person);
		
		System.out.println(person == person2);
	}
	
}
