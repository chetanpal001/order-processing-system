package com.example.orderprocessingsystem.scheduler;

import com.example.orderprocessingsystem.entity.Order;
import com.example.orderprocessingsystem.entity.OrderStatus;
import com.example.orderprocessingsystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class OrderStatusScheduler {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderStatusScheduler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Runs every 5 minutes
    @Scheduled(fixedRate = 300000)
    public void updatePendingOrdersToProcessing() {
        List<Order> pendingOrders = orderRepository.findByStatus(OrderStatus.PENDING);
        for (Order order : pendingOrders) {
            order.setStatus(OrderStatus.PROCESSING);
            order.setUpdatedAt(LocalDateTime.now());
            orderRepository.save(order);
        }
    }
}
