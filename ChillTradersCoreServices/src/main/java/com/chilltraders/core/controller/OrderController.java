package com.chilltraders.core.controller;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.XML;
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

import com.chilltraders.core.repository.OrderRepository;
import com.chilltraders.core.model.Order;
import com.chilltraders.core.exception.*;

@RestController
@RequestMapping("/xml")

public class OrderController {
	 @Autowired
	OrderRepository orderRepository;
	 
	 @GetMapping("/orders")
	    public String getAllOrders() {
			 List<Order> orders = orderRepository.findAll();
			 Iterator <Order> itr = orders.iterator();
			 Order anOrder = null;
			 String xmlOrders = "<Orders>";
			 while(itr.hasNext()) {
				 xmlOrders+= "<Order>";
				 anOrder = (Order) itr.next();
				 String xmlOrder = XML.toString(new JSONObject(anOrder));
			     xmlOrders+= xmlOrder;
			     xmlOrders+= "</Order>";
			 }
			 xmlOrders+= "</Orders>";
			 return xmlOrders;
	    }

	    @PostMapping("/orders")
	    public Order createOrder(@Valid @RequestBody Order order) {
	        return orderRepository.save(order);
	    }

	    @GetMapping("/orders/{id}")
	    public Order getOrderById(@PathVariable(value = "id") Long orderId) {
	        return orderRepository.findById(orderId)
	                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));
	    }

	    @PutMapping("/orders/{id}")
	    public Order updateOrder(@PathVariable(value = "id") Long orderId,
	                                           @Valid @RequestBody Order orderDetails) {

	        Order order = orderRepository.findById(orderId)
	                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));

	        
	        Order updatedOrder = orderRepository.save(order);
	        return updatedOrder;
	    }

	    @DeleteMapping("/orders/{id}")
	    public ResponseEntity<?> deleteOrder(@PathVariable(value = "id") Long orderId) {
	        Order order = orderRepository.findById(orderId)
	                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));

	        orderRepository.delete(order);

	        return ResponseEntity.ok().build();
	    }

}
