package com.chilltraders.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chilltraders.core.model.OrderLines;


@Repository
public interface OrderLinesRepository extends JpaRepository<OrderLines, Long> {
	

}
