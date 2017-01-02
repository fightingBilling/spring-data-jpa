package com.somnus.jpa.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.somnus.jpa.model.Person;

public interface PersonPagingRepsotory extends PagingAndSortingRepository<Person, Integer>{

}
