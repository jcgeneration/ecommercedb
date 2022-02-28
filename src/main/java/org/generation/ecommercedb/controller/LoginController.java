package org.generation.ecommercedb.controller;

import org.generation.ecommercedb.model.User;
import org.generation.ecommercedb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/login/")
@CrossOrigin(origins="*")
public class LoginController {
	private final UserService userService;
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}//constructor
	@PostMapping
	public String Login(@RequestBody User user) {
		String res = "Nombre de usuario o contraseña incorrectos";
		if (userService.login(user.getUsername(), user.getPassword())) {
			res ="ok";
		}// if 
		return res;
	} // Login
	
	
}//class UserController
