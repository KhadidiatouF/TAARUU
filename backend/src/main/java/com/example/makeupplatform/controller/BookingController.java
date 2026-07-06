package com.example.makeupplatform.controller;

import com.example.makeupplatform.dto.BookingDto;
import com.example.makeupplatform.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingDto> create(@RequestBody BookingDto dto) {
        return ResponseEntity.ok(bookingService.create(dto));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<BookingDto>> findAll() {
        return ResponseEntity.ok(bookingService.findAll());
    }

    @PatchMapping("/{id}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BookingDto> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(bookingService.updateStatus(id, status));
    }
}
