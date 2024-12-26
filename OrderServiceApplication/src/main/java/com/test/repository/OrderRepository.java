package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Order;

public interface OrderRepository  extends JpaRepository<Order,Integer>{

}
