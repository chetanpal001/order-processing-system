package com.example.orderprocessingsystem.service;

import com.example.orderprocessingsystem.dto.OrderRequest;
import com.example.orderprocessingsystem.dto.OrderResponse;
import com.example.orderprocessingsystem.entity.OrderStatus;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest request);
    OrderResponse getOrderById(Long orderId);
    List<OrderResponse> getAllOrders(OrderStatus status);
    OrderResponse updateOrderStatus(Long orderId, OrderStatus status);
    OrderResponse cancelOrder(Long orderId);
}
