package com.example.makeupplatform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Double salePrice;
    private Integer stock;
    private String category;
    private String brand;
    private String color;
    private String imageUrls;
    private Double rating;
    private Integer reviewCount;
    private Boolean featured;
}
