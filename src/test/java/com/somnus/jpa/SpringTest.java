package com.somnus.jpa;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.jpa.model.Person;
import com.somnus.jpa.repositories.PersonRepsotory;

public class SpringTest extends AbstractTestSupport{
	
	@Test
	public void testNativeQuery(){
		PersonRepsotory repsotory = ApplicationContextHolder.getBean(PersonRepsotory.class);
		long count = repsotory.getTotalCount();
		System.out.println(count);
	}
	
	@Test
	public void testQueryAnnotationLikeParam(){
		PersonRepsotory repsotory = ApplicationContextHolder.getBean(PersonRepsotory.class);
		/*List<Person> persons = repsotory.testQueryAnnotationLikeParam("%A%", "%bb%");
		System.out.println(persons.size());*/
		
		/*List<Person> persons = repsotory.testQueryAnnotationLikeParam("A", "bb");
		System.out.println(persons.size());*/
		
		List<Person> persons = repsotory.testQueryAnnotationLikeParam2("bb", "A");
		System.out.println(persons.size());
	}
	
	@Test
	public void testQueryAnnotationParams2(){
		PersonRepsotory repsotory = ApplicationContextHolder.getBean(PersonRepsotory.class);
		List<Person> persons = repsotory.testQueryAnnotationParams2("aa@atguigu.com", "AA");
		System.out.println(persons);
	}
	
	@Test
	public void testQueryAnnotationParams1(){
		PersonRepsotory repsotory = ApplicationContextHolder.getBean(PersonRepsotory.class);
		List<Person> persons = repsotory.testQueryAnnotationParams1("AA", "aa@atguigu.com");
		System.out.println(persons);
	}
	
	@Test
	public void testQueryAnnotation(){
		PersonRepsotory repsotory = ApplicationContextHolder.getBean(PersonRepsotory.class);
		Person person = repsotory.getMaxIdPerson();
		System.out.println(person);
	}
	
	@Test
	public void testKeyWords2(){
		PersonRepsotory repsotory = ApplicationContextHolder.getBean(PersonRepsotory.class);
		List<Person> persons = repsotory.getByAddress_IdGreaterThan(1);
		System.out.println(persons);
	}
	
	@Test
	public void testKeyWords(){
		PersonRepsotory repsotory = ApplicationContextHolder.getBean(PersonRepsotory.class);
		List<Person> persons = repsotory.getByLastNameStartingWithAndIdLessThan("X", 10);
		System.out.println(persons);
		
		persons = repsotory.getByLastNameEndingWithAndIdLessThan("X", 10);
		System.out.println(persons);
		
		persons = repsotory.getByEmailInAndBirthLessThan(Arrays.asList("AA@atguigu.com", "FF@atguigu.com", 
				"SS@atguigu.com"), new Date());
		System.out.println(persons.size());
	}
	
	@Test
	public void testHelloWorldSpringData() {
		PersonRepsotory repsotory = ApplicationContextHolder.getBean(PersonRepsotory.class);
		System.out.println(repsotory.getClass().getName());
		
		Person person = repsotory.getByLastName("AA");
		System.out.println(person);
	}
}
