package com.example.makeupplatform.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderDto {
    private Long id;
    private String customerName;
    private String email;
    private String deliveryAddress;
    private Double totalAmount;
    private String status;
    private List<OrderItemDto> items;
}
