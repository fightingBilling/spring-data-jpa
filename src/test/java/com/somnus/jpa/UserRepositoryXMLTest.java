package com.somnus.jpa;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.somnus.AbstractTestSupport;
import com.somnus.jpa.model.User;
import com.somnus.jpa.repositories.UserRepository;

public class UserRepositoryXMLTest extends AbstractTestSupport{
	@Autowired
	private UserRepository repository;

	@Test
	public void sampleTestCase() {
		User dave = new User("Dave", "Matthews");
		dave = repository.save(dave);

		User carter = new User("Carter", "Beauford");
		carter = repository.save(carter);

		List<User> result = repository.findByLastname("Matthews");
		System.out.println(result);
		System.out.println(repository.count());
	}
}
