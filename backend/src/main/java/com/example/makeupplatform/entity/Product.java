package com.example.makeupplatform.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    private Double price;
    private Double salePrice;
    private Integer stock;
    private String category;
    private String brand;
    private String color;
    private String imageUrls;
    private Double rating = 0.0;
    private Integer reviewCount = 0;
    private Boolean featured = false;
}
