package com.example.makeupplatform.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PortfolioItemDto {
    private Long id;
    private String title;
    private String description;
    private String eventType;
    private LocalDate eventDate;
    private String imageUrl;
    private String productsUsed;
}
