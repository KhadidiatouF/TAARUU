package com.example.makeupplatform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDto {
    private Long id;
    private String clientName;
    private Integer rating;
    private String comment;
    private String imageUrl;
    private Boolean featured;
}
