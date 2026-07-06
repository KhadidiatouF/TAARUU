package com.example.makeupplatform.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookingDto {
    private Long id;
    private Long serviceOfferId;
    private String serviceName;
    private LocalDate bookingDate;
    private String bookingTime;
    private String customerName;
    private String phone;
    private String email;
    private String remarks;
    private String status;
}
