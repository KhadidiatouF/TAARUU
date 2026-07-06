package com.example.makeupplatform.service;

import com.example.makeupplatform.dto.ProductDto;
import com.example.makeupplatform.entity.Product;
import com.example.makeupplatform.exception.ResourceNotFoundException;
import com.example.makeupplatform.mapper.ProductMapper;
import com.example.makeupplatform.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Page<ProductDto> findAll(String keyword, String category, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> result;
        if (keyword != null && !keyword.isBlank() && category != null && !category.isBlank()) {
            result = repository.findByCategoryIgnoreCaseAndNameContainingIgnoreCase(category, keyword, pageable);
        } else if (category != null && !category.isBlank()) {
            result = repository.findByCategoryIgnoreCase(category, pageable);
        } else if (keyword != null && !keyword.isBlank()) {
            result = repository.findByNameContainingIgnoreCase(keyword, pageable);
        } else {
            result = repository.findAll(pageable);
        }
        return result.map(ProductMapper::toDto);
    }

    public ProductDto findById(Long id) {
        return repository.findById(id).map(ProductMapper::toDto).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public ProductDto save(ProductDto dto) {
        Product entity = Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .salePrice(dto.getSalePrice())
                .stock(dto.getStock())
                .category(dto.getCategory())
                .brand(dto.getBrand())
                .color(dto.getColor())
                .imageUrls(dto.getImageUrls())
                .rating(dto.getRating())
                .reviewCount(dto.getReviewCount())
                .featured(dto.getFeatured())
                .build();
        return ProductMapper.toDto(repository.save(entity));
    }

    public ProductDto update(Long id, ProductDto dto) {
        Product entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setSalePrice(dto.getSalePrice());
        entity.setStock(dto.getStock());
        entity.setCategory(dto.getCategory());
        entity.setBrand(dto.getBrand());
        entity.setColor(dto.getColor());
        entity.setImageUrls(dto.getImageUrls());
        entity.setRating(dto.getRating());
        entity.setReviewCount(dto.getReviewCount());
        entity.setFeatured(dto.getFeatured());
        return ProductMapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
