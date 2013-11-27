package com.tsystems.lection12.backing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tsystems.lection12.entities.User;
import com.tsystems.lection12.service.UserService;

//Setup UserController as Managed Bean by @Named
@Named
//Determine Scope for Managed Bean from javax.enterprise.context package
@RequestScoped
public class UserController {

	@Inject
	private UserService userService;
	
	public String testCreateUser(){
		System.out.println("----------------------------------------------------------");
		System.out.println("Create new User item");
		userService.createUser(generateUser());
		System.out.println("----------------------------------------------------------");
		return "";
	}
	
	public String testDeleteUser() {
		System.out.println("----------------------------------------------------------");
		System.out.println("Delete User item");
		userService.deleteUserById(generateUser().getEmail());
		System.out.println("----------------------------------------------------------");
		return "";
	}
	
	public String testFindAllUsers() {
		System.out.println("----------------------------------------------------------");
		System.out.println("Start Finding users");
		List<User> users = (ArrayList<User>) userService.findAllUsers();
		for (User user : users) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getEmail() );
		}
		System.out.println("----------------------------------------------------------");
		return "";
	}
	
	public String testFindUserByEmail() {
		System.out.println("----------------------------------------------------------");
		System.out.println("Start Finding user by ID");
		User user = userService.findUserByEmail("L12User@gmail.com");
		System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getEmail() );
		System.out.println("----------------------------------------------------------");
		return "";
	}
	
	private User generateUser(){
		User user = new User();
		user.setFirstName("L12User");
		user.setLastName("L12UserFamiliy");
		user.setEmail("L12User@gmail.com");
		user.setPassword("12345");
		user.setBirthday(new Date());
		return user;
	}
}
