package com.chilltraders.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chilltraders.core.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	

}
