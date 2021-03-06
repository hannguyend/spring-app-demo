package com.bg.rental.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.bg.rental.annotation.UniqueUsername;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 3, message = "Name must be at lease 3 characters!")
	@Column(unique = true)
	@UniqueUsername(message = "Such username already exists! Please use a different one. ")
	private String name;
	
	@Size (min = 1, message = "Invalid email address")
	@Email
	private String email;
	
	@Size(min = 4, message = "Password must be at least 4 characters!")
	private String password;
	
	private boolean enable;
	
	@ManyToMany
	@JoinTable
	private List<Role> roles;
	
	@OneToMany (mappedBy = "user", cascade=CascadeType.REMOVE)
	private List<Blog> blogs;

	
	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}
}
