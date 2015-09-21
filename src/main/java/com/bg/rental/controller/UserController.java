package com.bg.rental.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bg.rental.entity.Blog;
import com.bg.rental.entity.User;
import com.bg.rental.service.BlogService;
import com.bg.rental.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;	
	
	@Autowired
	private BlogService blogService;
	
    /* This is used for spring from autowired from jsp page */	
	@ModelAttribute("userController")
	private User constructUser() {
		return new User();
	}
	
	/* This is used for spring from autowired from jsp page */	
	@ModelAttribute("blogC")
	private Blog constructBlog() {
		return new Blog();
	}
	
	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
	/** {id} is used for dynamic references from the front with any id
	 * This is good for creating a dynamic page with any user that has 
	 * the same information.
	 * */
	@RequestMapping("/users/{id}")
	public String detail(Model model, @PathVariable int id){
		model.addAttribute("user", userService.findOneWithBlog(id));
		return "user-detail";
	}
	
	@RequestMapping("/register")
	public String showRegister() {
		return "user-register";
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user){
		userService.save(user);
		return "redirect:/register?success=true";
	}	
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal ) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithBlog(name));
		return "user-detail";
	}
	
	@RequestMapping(value = "/account", method=RequestMethod.POST)
	public String addBlog(@ModelAttribute("blog") Blog blog, Principal principal){
		String name = principal.getName();
		blogService.save(blog, name);
		return "redirect:/account";
	}
	
	@RequestMapping("blog/remove/{id}")
	public String removeBlog(@PathVariable int id) {
		blogService.delete(id);
		return "redirect:/account";
	}
	
	@RequestMapping("users/remove/{id}")
	public String removeUser(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/users";
	}
}





