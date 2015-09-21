package com.bg.rental.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
    /* This is used for spring from autowired from jsp page
     * This ModelAttribute param should be the same with the form
     * */	
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
	
	/*
	 * ModelAttribute param has to be the same with commandName of the associated form. 
	 * In my case, it should be userController
	 */
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("userController") User user, BindingResult result){
		if (result.hasErrors()) {
			return "user-register";
		}
		userService.save(user);
		return "redirect:/register?success=true";
	}	
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal ) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithBlog(name));
		return "user-detail";
	}
	
	/*
	 * ModelAttribute param should be the same with the associated form.
	 * In my case, <form:form commandName = "blogC", and ModelAttribute should be "blogC"
	 */
	@RequestMapping(value = "/account", method=RequestMethod.POST)
	public String addBlog(Model model, @Valid @ModelAttribute("blogC") Blog blog, BindingResult result, Principal principal){
		if (result.hasErrors()) {
			return account(model, principal);
		}
		String name = principal.getName();
		blogService.save(blog, name);
		return "redirect:/account";
	}
	
	@RequestMapping("blog/remove/{id}")
	public String removeBlog(@PathVariable int id) {
		Blog blog = blogService.findOne(id);
		blogService.delete(blog);
		return "redirect:/account";
	}
	
	@RequestMapping("users/remove/{id}")
	public String removeUser(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/users";
	}
}