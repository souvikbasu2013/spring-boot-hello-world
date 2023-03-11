package com.example.helloworld.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.helloworld.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByUsername(String username);
}
