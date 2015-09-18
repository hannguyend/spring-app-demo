package com.bg.rental.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bg.rental.entity.Blog;
import com.bg.rental.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	/*
	 * Pageable is used to limit the number of row data that are retrieved 
	 * from database.
	 */
	List<Item> findByBlog (Blog blog, Pageable pageable);

}
