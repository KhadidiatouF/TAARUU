package com.example.makeupplatform.repository;

import com.example.makeupplatform.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
