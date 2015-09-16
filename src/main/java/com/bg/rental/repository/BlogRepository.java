package com.bg.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bg.rental.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
