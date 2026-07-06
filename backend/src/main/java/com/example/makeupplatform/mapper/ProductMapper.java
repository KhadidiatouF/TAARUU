package com.example.makeupplatform.mapper;

import com.example.makeupplatform.dto.ProductDto;
import com.example.makeupplatform.entity.Product;

public class ProductMapper {
    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .salePrice(product.getSalePrice())
                .stock(product.getStock())
                .category(product.getCategory())
                .brand(product.getBrand())
                .color(product.getColor())
                .imageUrls(product.getImageUrls())
                .rating(product.getRating())
                .reviewCount(product.getReviewCount())
                .featured(product.getFeatured())
                .build();
    }
}
