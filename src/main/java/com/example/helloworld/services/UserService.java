package com.example.helloworld.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.helloworld.entities.User;
import com.example.helloworld.exception.UserNameNotFoundException;
import com.example.helloworld.exception.UserNotFoundException;
import com.example.helloworld.repositories.UserRepository;

@Service
public class UserService {

	@Autowired UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User getUser(Long id) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(id);
		if(!optionalUser.isEmpty()) {
			return optionalUser.get();
		}else {
			throw new UserNotFoundException("User not found with the id...");
		}
	}
	
	public User getUserByName(String username) throws UserNameNotFoundException {
		List<User> optionalUser = userRepository.findByUsername(username);
		if(optionalUser!=null && optionalUser.size()>0) {
			return optionalUser.get(0);
		}else {
			throw new UserNameNotFoundException("User Name "+username+" not found in the repository...");
		}
	}
	
	public User updateUser(User user, Long id) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(id);
		if(!optionalUser.isEmpty()) {
			return userRepository.save(user);
		}else {
			throw new UserNotFoundException("User not found with the id...");
		}
	}
	
	public void deleteUser(Long id){
		Optional<User> optionalUser = userRepository.findById(id);
		if(!optionalUser.isEmpty()) {
			userRepository.deleteById(id);
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User not found with the id, please provide correct id...");
		}
		
	}
}
