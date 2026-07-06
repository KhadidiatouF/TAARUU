package com.example.makeupplatform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceOfferDto {
    private Long id;
    private String name;
    private String description;
    private Integer durationMinutes;
    private Double price;
    private String photoUrl;
    private String category;
    private String availability;
    private Boolean active;
}
