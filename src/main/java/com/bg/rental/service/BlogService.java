package com.bg.rental.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
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

	public void delete(int id) {
		blogRepository.delete(id);		
	}

	public Blog findOne(int id) {
		return blogRepository.findOne(id);
	}
	
	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogRepository.delete(blog);
	}
}
