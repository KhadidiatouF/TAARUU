package com.example.makeupplatform.controller;

import com.example.makeupplatform.dto.PortfolioItemDto;
import com.example.makeupplatform.dto.ProductDto;
import com.example.makeupplatform.dto.ReviewDto;
import com.example.makeupplatform.dto.ServiceOfferDto;
import com.example.makeupplatform.service.PortfolioService;
import com.example.makeupplatform.service.ProductService;
import com.example.makeupplatform.service.ReviewService;
import com.example.makeupplatform.service.ServiceOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class PublicController {
    private final ServiceOfferService serviceOfferService;
    private final ProductService productService;
    private final PortfolioService portfolioService;
    private final ReviewService reviewService;

    @GetMapping("/services")
    public ResponseEntity<List<ServiceOfferDto>> services() {
        return ResponseEntity.ok(serviceOfferService.findAll());
    }

    @GetMapping("/products")
    public ResponseEntity<?> products(@RequestParam(required = false) String keyword,
                                      @RequestParam(required = false) String category,
                                      @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "8") int size) {
        return ResponseEntity.ok(productService.findAll(keyword, category, page, size));
    }

    @GetMapping("/portfolio")
    public ResponseEntity<List<PortfolioItemDto>> portfolio() {
        return ResponseEntity.ok(portfolioService.findAll());
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewDto>> reviews() {
        return ResponseEntity.ok(reviewService.findAll());
    }
}
