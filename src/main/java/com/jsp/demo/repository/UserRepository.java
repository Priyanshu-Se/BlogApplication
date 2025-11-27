package com.jsp.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

	boolean existsByPhoneNumber(String phoneNumber);

	Optional<User> findByUsername(String username);

	Optional<User> findByUsernameAndPassword(String username,String password);

	Optional<User> findByEmail(String email);

	Optional<User> findByPhoneNumber(String phoneNumber);

}
