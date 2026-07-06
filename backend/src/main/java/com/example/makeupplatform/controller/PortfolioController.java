package com.example.makeupplatform.controller;

import com.example.makeupplatform.dto.PortfolioItemDto;
import com.example.makeupplatform.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/portfolio")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class PortfolioController {
    private final PortfolioService portfolioService;

    @PostMapping
    public ResponseEntity<PortfolioItemDto> create(@RequestBody PortfolioItemDto dto) {
        return ResponseEntity.ok(portfolioService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioItemDto> update(@PathVariable Long id, @RequestBody PortfolioItemDto dto) {
        return ResponseEntity.ok(portfolioService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        portfolioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
