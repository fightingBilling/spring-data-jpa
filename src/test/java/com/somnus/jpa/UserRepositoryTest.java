package com.somnus.jpa;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.somnus.jpa.model.User;
import com.somnus.jpa.repositories.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserRepositoryTest {
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
