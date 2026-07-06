package com.example.makeupplatform.mapper;

import com.example.makeupplatform.dto.ServiceOfferDto;
import com.example.makeupplatform.entity.ServiceOffer;

public class ServiceOfferMapper {
    public static ServiceOfferDto toDto(ServiceOffer offer) {
        return ServiceOfferDto.builder()
                .id(offer.getId())
                .name(offer.getName())
                .description(offer.getDescription())
                .durationMinutes(offer.getDurationMinutes())
                .price(offer.getPrice())
                .photoUrl(offer.getPhotoUrl())
                .category(offer.getCategory())
                .availability(offer.getAvailability())
                .active(offer.getActive())
                .build();
    }
}
