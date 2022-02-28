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
		return userRepository.findById(userId).orElseThrow(
			()-> new IllegalStateException("El usuario con el id " + userId + " no existe")
			);
	}// getUser

	public void deleteUser(Long userId) {
		if(userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
		} else {
			throw new IllegalStateException("El usuario con el id " + userId + " no existe");
		} //else 
	} // deleteUser

	public void addUser(User user) {
		Optional<User> userByName = userRepository.findByUsername(user.getUsername());
		if (userByName.isPresent()) {
			throw new IllegalStateException("El usuario con el nombre " + user.getUsername() 
		+ " ya existe"); 
		}// if
			userRepository.save(user);	
	}// addUser

	public void updateUser(Long userId, String currentPassword, String newPassword) {
		if (userRepository.existsById(userId)) {
			User user = userRepository.getById(userId);
			if ((newPassword !=null) && (currentPassword !=null)) {
				if ( (user.getPassword().equals(currentPassword)) && 
					(! user.getPassword().equals(newPassword) ) ) {
					user.setPassword(newPassword);	
					userRepository.save(user);
				} else {
					throw new IllegalStateException("Contraseña incorrecta");	
				}//else // if equals
			}else {
				throw new IllegalStateException("Contraseñas nulas");	
			}//else  // !=null
		}else {
			throw new IllegalStateException("Usuario no encontrado " + userId);	
		}//else //if existsById
		
	} // updateUser
	

	
	
	
}//class UserService
