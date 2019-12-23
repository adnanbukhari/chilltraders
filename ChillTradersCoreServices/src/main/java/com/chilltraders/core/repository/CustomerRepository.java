package com.chilltraders.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chilltraders.core.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
