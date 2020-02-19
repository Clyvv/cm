package com.citysoft.cm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citysoft.cm.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	User findByEmail(String email);

    Boolean existsByEmail(String email);
}
