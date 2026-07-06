package com.example.makeupplatform.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;
    private Integer rating;
    private String comment;
    private String imageUrl;
    private Boolean featured = false;
    private LocalDateTime createdAt = LocalDateTime.now();
}
