package com.example.makeupplatform.service;

import com.example.makeupplatform.dto.PortfolioItemDto;
import com.example.makeupplatform.entity.PortfolioItem;
import com.example.makeupplatform.exception.ResourceNotFoundException;
import com.example.makeupplatform.mapper.PortfolioMapper;
import com.example.makeupplatform.repository.PortfolioItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioService {
    private final PortfolioItemRepository repository;

    public List<PortfolioItemDto> findAll() {
        return repository.findAll().stream().map(PortfolioMapper::toDto).toList();
    }

    public PortfolioItemDto save(PortfolioItemDto dto) {
        PortfolioItem entity = PortfolioItem.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .eventType(dto.getEventType())
                .eventDate(dto.getEventDate())
                .imageUrl(dto.getImageUrl())
                .productsUsed(dto.getProductsUsed())
                .build();
        return PortfolioMapper.toDto(repository.save(entity));
    }

    public PortfolioItemDto update(Long id, PortfolioItemDto dto) {
        PortfolioItem entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Portfolio item not found"));
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setEventType(dto.getEventType());
        entity.setEventDate(dto.getEventDate());
        entity.setImageUrl(dto.getImageUrl());
        entity.setProductsUsed(dto.getProductsUsed());
        return PortfolioMapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
