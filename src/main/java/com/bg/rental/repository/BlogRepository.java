package com.bg.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bg.rental.entity.Blog;
import com.bg.rental.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findByUser(User user);

}
