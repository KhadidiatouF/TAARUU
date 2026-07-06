package com.example.makeupplatform.mapper;

import com.example.makeupplatform.dto.BookingDto;
import com.example.makeupplatform.entity.Booking;

public class BookingMapper {
    public static BookingDto toDto(Booking booking) {
        return BookingDto.builder()
                .id(booking.getId())
                .serviceOfferId(booking.getServiceOffer() != null ? booking.getServiceOffer().getId() : null)
                .serviceName(booking.getServiceOffer() != null ? booking.getServiceOffer().getName() : null)
                .bookingDate(booking.getBookingDate())
                .bookingTime(booking.getBookingTime())
                .customerName(booking.getCustomerName())
                .phone(booking.getPhone())
                .email(booking.getEmail())
                .remarks(booking.getRemarks())
                .status(booking.getStatus().name())
                .build();
    }
}
