package com.example.helloworld.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.helloworld.entities.User;

@Repository
public interface UserRepositories extends JpaRepository<User, Long>{

}
