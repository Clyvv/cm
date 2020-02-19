package com.citysoft.cm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citysoft.cm.model.Title;

@Repository
public interface TitleRepository extends JpaRepository<Title,Integer>{

}
