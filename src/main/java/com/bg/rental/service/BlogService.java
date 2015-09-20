package com.bg.rental.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.rental.entity.Blog;
import com.bg.rental.entity.User;
import com.bg.rental.repository.BlogRepository;
import com.bg.rental.repository.UserRepository;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void save(Blog blog, String name){
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);		
	}
}
