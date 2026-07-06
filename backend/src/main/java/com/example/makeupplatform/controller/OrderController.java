package com.example.makeupplatform.controller;

import com.example.makeupplatform.dto.OrderDto;
import com.example.makeupplatform.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto dto, Authentication authentication) {
        return ResponseEntity.ok(orderService.create(dto, authentication.getName()));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<OrderDto>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }
}
