package com.chilltraders.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chilltraders.core.repository.CustomerRepository;
import com.chilltraders.core.model.*;
import com.chilltraders.core.exception.*;

@RestController
@RequestMapping("/api")

public class CustomerController {
	 @Autowired
	CustomerRepository customerRepository;
	 
	 @GetMapping("/customers")
	    public List<Customer> getAllCustomers() {
	        return customerRepository.findAll();
	    }

	    @PostMapping("/customers")
	    public Customer createCustomer(@Valid @RequestBody Customer customer) {
	        return customerRepository.save(customer);
	    }

	    @GetMapping("/customers/{id}")
	    public Customer getCustomerById(@PathVariable(value = "id") Long customerId) {
	        return customerRepository.findById(customerId)
	                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
	    }

	    @PutMapping("/customers/{id}")
	    public Customer updateCustomer(@PathVariable(value = "id") Long customerId,
	                                           @Valid @RequestBody Customer customerDetails) {

	        Customer customer = customerRepository.findById(customerId)
	                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));

	        
	        Customer updatedCustomer = customerRepository.save(customer);
	        return updatedCustomer;
	    }

	    @DeleteMapping("/customers/{id}")
	    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long customerId) {
	        Customer customer = customerRepository.findById(customerId)
	                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));

	        customerRepository.delete(customer);

	        return ResponseEntity.ok().build();
	    }


}
