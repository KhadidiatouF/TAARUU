package com.example.makeupplatform.mapper;

import com.example.makeupplatform.dto.ReviewDto;
import com.example.makeupplatform.entity.Review;

public class ReviewMapper {
    public static ReviewDto toDto(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .clientName(review.getClientName())
                .rating(review.getRating())
                .comment(review.getComment())
                .imageUrl(review.getImageUrl())
                .featured(review.getFeatured())
                .build();
    }
}
