package com.somnus.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somnus.jpa.model.Person;

public interface PersonJpaRepsotory extends JpaRepository<Person, Integer>{

}
