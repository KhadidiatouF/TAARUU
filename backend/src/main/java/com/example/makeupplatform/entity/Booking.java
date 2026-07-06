package com.example.makeupplatform.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private ServiceOffer serviceOffer;

    private LocalDate bookingDate;
    private String bookingTime;
    private String customerName;
    private String phone;
    private String email;
    private String remarks;

    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.PENDING;

    private LocalDateTime createdAt = LocalDateTime.now();

    public enum BookingStatus {
        PENDING,
        CONFIRMED,
        CANCELLED,
        REJECTED
    }
}
