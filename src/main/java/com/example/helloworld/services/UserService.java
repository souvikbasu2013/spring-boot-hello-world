package com.example.helloworld.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helloworld.entities.User;
import com.example.helloworld.repositories.UserRepositories;

@Service
public class UserService {

	@Autowired UserRepositories userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User getUser(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(!optionalUser.isEmpty()) {
			return optionalUser.get();
		}else {
			return null; //TODO: throwException
		}
	}
	
	public User updateUser(User user, Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(!optionalUser.isEmpty()) {
			return userRepository.save(user);
		}else {
			return null; //TODO: throwException
		}
	}
	
	public void deleteUser(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(!optionalUser.isEmpty()) {
			userRepository.deleteById(id);
		}else {
			//TODO: throwException
		}
		
	}
}
