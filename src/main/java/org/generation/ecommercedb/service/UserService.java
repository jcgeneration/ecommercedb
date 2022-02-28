package org.generation.ecommercedb.service;

import java.util.Optional;

import org.generation.ecommercedb.model.User;
import org.generation.ecommercedb.utils.SHAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}//constructor
	
	public boolean login(String username, String password) {
		boolean res=false;
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			System.out.println("Password SHA: " + SHAUtil.createHash(password));
			if (user.get().getPassword().equals(password)) {
				res=true;
			}// if password
		}//if isPresent
		return res;
	}//login
	
	
	
}//class UserService
