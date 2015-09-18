package com.bg.rental.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bg.rental.entity.Blog;
import com.bg.rental.entity.Item;
import com.bg.rental.entity.User;
import com.bg.rental.repository.BlogRepository;
import com.bg.rental.repository.ItemRepository;
import com.bg.rental.repository.UserRepository;

/**
 * Service class has to have @Service annotation
 */
@Service
public class UserService {

	/**
	 * Autowired is used to call database
	 */
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private ItemRepository itemRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	/**
	 * Anything that access database is annotated as @Transactional.
	 * @param id
	 * @return
	 */
	@Transactional
	public User findOneWithBlog(int id) {
		User user = findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for (Blog blog : blogs) {
			// PageRequest is used here for page number, size, sorting, and
			// sorting properties.
			List<Item> items = 
					itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}
}