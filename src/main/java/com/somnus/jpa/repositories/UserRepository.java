package com.somnus.jpa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.somnus.jpa.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByLastname(String lastname);
}
