package com.bg.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bg.rental.entity.Role;
import com.bg.rental.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);

}
