package com.example.makeupplatform.mapper;

import com.example.makeupplatform.dto.PortfolioItemDto;
import com.example.makeupplatform.entity.PortfolioItem;

public class PortfolioMapper {
    public static PortfolioItemDto toDto(PortfolioItem item) {
        return PortfolioItemDto.builder()
                .id(item.getId())
                .title(item.getTitle())
                .description(item.getDescription())
                .eventType(item.getEventType())
                .eventDate(item.getEventDate())
                .imageUrl(item.getImageUrl())
                .productsUsed(item.getProductsUsed())
                .build();
    }
}
