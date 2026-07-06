package com.example.makeupplatform.controller;

import com.example.makeupplatform.dto.ReviewDto;
import com.example.makeupplatform.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewDto> create(@RequestBody ReviewDto dto) {
        return ResponseEntity.ok(reviewService.save(dto));
    }
}
