package com.example.makeupplatform.service;

import com.example.makeupplatform.dto.ReviewDto;
import com.example.makeupplatform.entity.Review;
import com.example.makeupplatform.mapper.ReviewMapper;
import com.example.makeupplatform.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository repository;

    public List<ReviewDto> findAll() {
        return repository.findAll().stream().map(ReviewMapper::toDto).toList();
    }

    public ReviewDto save(ReviewDto dto) {
        Review review = Review.builder()
                .clientName(dto.getClientName())
                .rating(dto.getRating())
                .comment(dto.getComment())
                .imageUrl(dto.getImageUrl())
                .featured(dto.getFeatured())
                .build();
        return ReviewMapper.toDto(repository.save(review));
    }
}
