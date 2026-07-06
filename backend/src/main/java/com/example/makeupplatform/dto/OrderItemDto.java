package com.example.makeupplatform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemDto {
    private String productName;
    private Integer quantity;
    private Double unitPrice;
}
