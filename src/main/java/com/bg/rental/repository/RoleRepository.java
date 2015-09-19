package com.bg.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bg.rental.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);

}
