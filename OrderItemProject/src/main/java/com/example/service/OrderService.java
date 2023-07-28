package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Order;
import com.example.exception.OrderNotFoundException;
import com.example.repository.OrderRepository;

	@Service
	public class OrderService {

	    @Autowired
	    private OrderRepository orderRepository;

	    public Order createOrder(Order order) {
	        return orderRepository.save(order);
	    }

	    public List<Order> getAllOrders() {
	        return orderRepository.findAll();
	    }

	    public Order getOrderById(Long orderId) {
	        return orderRepository.findById(orderId)
	                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + orderId));
	    }

//	    public Order updateOrder(Long orderId, Order updatedOrder) {
//	        Order existingOrder = getOrderById(orderId);
//	        // Perform any necessary updates to the existingOrder object based on updatedOrder
//	        return orderRepository.save(existingOrder);
//	    }

	    
	}

