package com.example.makeupplatform.service;

import com.example.makeupplatform.dto.OrderDto;
import com.example.makeupplatform.dto.OrderItemDto;
import com.example.makeupplatform.entity.Order;
import com.example.makeupplatform.entity.OrderItem;
import com.example.makeupplatform.entity.Product;
import com.example.makeupplatform.entity.User;
import com.example.makeupplatform.exception.ResourceNotFoundException;
import com.example.makeupplatform.repository.OrderRepository;
import com.example.makeupplatform.repository.ProductRepository;
import com.example.makeupplatform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderDto create(OrderDto dto, String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Order order = Order.builder()
                .user(user)
                .customerName(dto.getCustomerName())
                .email(dto.getEmail())
                .deliveryAddress(dto.getDeliveryAddress())
                .totalAmount(dto.getTotalAmount())
                .items(new ArrayList<>())
                .build();
        for (OrderItemDto itemDto : dto.getItems()) {
            Product product = productRepository.findById(Long.parseLong(itemDto.getProductName())).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
            OrderItem item = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .quantity(itemDto.getQuantity())
                    .unitPrice(itemDto.getUnitPrice())
                    .build();
            order.getItems().add(item);
        }
        Order savedOrder = orderRepository.save(order);
        return toDto(savedOrder);
    }

    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream().map(this::toDto).toList();
    }

    private OrderDto toDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .customerName(order.getCustomerName())
                .email(order.getEmail())
                .deliveryAddress(order.getDeliveryAddress())
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus().name())
                .items(order.getItems().stream().map(item -> OrderItemDto.builder()
                        .productName(item.getProduct().getName())
                        .quantity(item.getQuantity())
                        .unitPrice(item.getUnitPrice())
                        .build()).toList())
                .build();
    }
}
