package com.bg.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bg.rental.entity.User;
import com.bg.rental.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;	
	
    /* This is used for spring from autowired from jsp page */	
	@ModelAttribute("userController")
	private User userConstruct() {
		return new User();
	}
	
	@ModelAttribute("anotherUserController")
	private User userConstruction() {
		return new User();
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
	@RequestMapping("/anotherRegister")
	public String showAnotherRegister() {
		return "another-user-register";
	}
}
