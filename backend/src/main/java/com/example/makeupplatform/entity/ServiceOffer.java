package com.example.makeupplatform.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "service_offers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    private Integer durationMinutes;
    private Double price;
    private String photoUrl;
    private String category;
    private String availability;
    private Boolean active = true;
}
