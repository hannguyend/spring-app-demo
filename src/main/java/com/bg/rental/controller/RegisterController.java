package com.bg.rental.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bg.rental.entity.User;
import com.bg.rental.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserService userService;
	
	 /* This is used for spring from autowired from jsp page
     * This ModelAttribute param should be the same with the form
     * */	
	@ModelAttribute("userController")
	private User constructUser() {
		return new User();
	}
	

	@RequestMapping
	public String showRegister() {
		return "user-register";
	}

	/*
	 * ModelAttribute param has to be the same with commandName of the
	 * associated form. In my case, it should be userController
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("userController") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user-register";
		}
		userService.save(user);
		return "redirect:/register?success=true";
	}
}