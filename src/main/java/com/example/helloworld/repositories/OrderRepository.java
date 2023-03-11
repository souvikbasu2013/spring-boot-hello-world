package com.example.helloworld.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.helloworld.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
