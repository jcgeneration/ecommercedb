package org.generation.ecommercedb.service;

import java.util.Optional;

import org.generation.ecommercedb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.username=?1")
	 Optional<User> findByUsername(String username);
} // interface
