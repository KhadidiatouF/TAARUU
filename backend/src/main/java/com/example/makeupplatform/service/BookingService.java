package com.example.makeupplatform.service;

import com.example.makeupplatform.dto.BookingDto;
import com.example.makeupplatform.entity.Booking;
import com.example.makeupplatform.entity.ServiceOffer;
import com.example.makeupplatform.exception.ResourceNotFoundException;
import com.example.makeupplatform.mapper.BookingMapper;
import com.example.makeupplatform.repository.BookingRepository;
import com.example.makeupplatform.repository.ServiceOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final ServiceOfferRepository serviceOfferRepository;

    public BookingDto create(BookingDto dto) {
        ServiceOffer offer = serviceOfferRepository.findById(dto.getServiceOfferId()).orElseThrow(() -> new ResourceNotFoundException("Service not found"));
        Booking booking = Booking.builder()
                .serviceOffer(offer)
                .bookingDate(dto.getBookingDate())
                .bookingTime(dto.getBookingTime())
                .customerName(dto.getCustomerName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .remarks(dto.getRemarks())
                .build();
        return BookingMapper.toDto(bookingRepository.save(booking));
    }

    public List<BookingDto> findAll() {
        return bookingRepository.findAll().stream().map(BookingMapper::toDto).toList();
    }

    public BookingDto updateStatus(Long id, String status) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
        booking.setStatus(Booking.BookingStatus.valueOf(status.toUpperCase()));
        return BookingMapper.toDto(bookingRepository.save(booking));
    }
}
