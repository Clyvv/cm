package com.citysoft.cm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citysoft.cm.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>{

}
