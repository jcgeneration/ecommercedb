package org.generation.ecommercedb.service;

import java.util.List;
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

	public List<User> getUsers() {
		return userRepository.findAll();
	}//getUsers

	public User getUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(Long userId, String currentPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}
	

	
	
	
}//class UserService
