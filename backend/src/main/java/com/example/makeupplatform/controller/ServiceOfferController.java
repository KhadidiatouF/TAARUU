package com.example.makeupplatform.controller;

import com.example.makeupplatform.dto.ServiceOfferDto;
import com.example.makeupplatform.service.ServiceOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/services")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class ServiceOfferController {
    private final ServiceOfferService serviceOfferService;

    @GetMapping
    public ResponseEntity<List<ServiceOfferDto>> findAll() {
        return ResponseEntity.ok(serviceOfferService.findAll());
    }

    @PostMapping
    public ResponseEntity<ServiceOfferDto> create(@RequestBody ServiceOfferDto dto) {
        return ResponseEntity.ok(serviceOfferService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceOfferDto> update(@PathVariable Long id, @RequestBody ServiceOfferDto dto) {
        return ResponseEntity.ok(serviceOfferService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        serviceOfferService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
