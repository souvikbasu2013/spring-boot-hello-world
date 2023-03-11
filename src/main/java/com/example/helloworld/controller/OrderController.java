package com.example.helloworld.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.helloworld.entities.Order;
import com.example.helloworld.entities.User;
import com.example.helloworld.exception.UserNameNotFoundException;
import com.example.helloworld.exception.UserNotFoundException;
import com.example.helloworld.repositories.OrderRepository;
import com.example.helloworld.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class OrderController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/{userId}/orders")
	public List<Order> getAllOrders(@PathVariable Long userId) throws UserNotFoundException{
		Optional<User> optionalUser = userRepository.findById(userId);
		if(optionalUser.isPresent()) {
			return optionalUser.get().getOrders();
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
	}
	
	@PostMapping("/{userId}/orders")
	public Order createOrder(@PathVariable Long userId, @RequestBody Order order) throws UserNotFoundException{
		Optional<User> optionalUser = userRepository.findById(userId);
		if(optionalUser.isPresent()) {
			order.setUser(optionalUser.get());
			return orderRepository.save(order);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
	}
	
	@GetMapping("/{userId}/orders/{orderId}")
	public Order getOrderById(@PathVariable Long userId,@PathVariable Long orderId) throws UserNotFoundException{
		/*
		 * Optional<User> optionalUser = userRepository.findById(userId);
		 * if(optionalUser.isPresent()) { return optionalUser.get().getOrders(); }else {
		 * throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"); }
		 */

		 Optional<Order> optionalOrder = orderRepository.findById(orderId);
		 if(optionalOrder.isPresent()) 
		 { 
			 return optionalOrder.get(); 
		 }else {
		 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"); }
		 
	}
}
