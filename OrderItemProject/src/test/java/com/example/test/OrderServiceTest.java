package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.entity.Order;
import com.example.exception.OrderNotFoundException;
import com.example.repository.OrderRepository;
import com.example.service.OrderService;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

	
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void testGetOrderById_Success() {
        Long orderId = 1L;
        Order order = new Order();
        order.setOrderId(orderId);
       when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        Order result = orderService.getOrderById(orderId);

        assertNotNull(result);
        assertEquals(orderId, result.getOrderId());
        verify(orderRepository, times(1)).findById(orderId);
    }

    @Test
    public void testGetOrderById_OrderNotFound() {
        Long orderId = 2L;
        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());

        assertThrows(OrderNotFoundException.class, () -> orderService.getOrderById(orderId));

        verify(orderRepository, times(1)).findById(orderId);
    }

    // Similar test cases for other methods in OrderService
}
