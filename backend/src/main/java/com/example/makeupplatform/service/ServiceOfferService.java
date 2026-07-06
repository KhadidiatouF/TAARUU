package com.example.makeupplatform.service;

import com.example.makeupplatform.dto.ServiceOfferDto;
import com.example.makeupplatform.entity.ServiceOffer;
import com.example.makeupplatform.exception.ResourceNotFoundException;
import com.example.makeupplatform.mapper.ServiceOfferMapper;
import com.example.makeupplatform.repository.ServiceOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceOfferService {
    private final ServiceOfferRepository repository;

    public List<ServiceOfferDto> findAll() {
        return repository.findAll().stream().map(ServiceOfferMapper::toDto).toList();
    }

    public ServiceOfferDto findById(Long id) {
        return repository.findById(id).map(ServiceOfferMapper::toDto).orElseThrow(() -> new ResourceNotFoundException("Service not found"));
    }

    public ServiceOfferDto save(ServiceOfferDto dto) {
        ServiceOffer entity = ServiceOffer.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .durationMinutes(dto.getDurationMinutes())
                .price(dto.getPrice())
                .photoUrl(dto.getPhotoUrl())
                .category(dto.getCategory())
                .availability(dto.getAvailability())
                .active(dto.getActive())
                .build();
        return ServiceOfferMapper.toDto(repository.save(entity));
    }

    public ServiceOfferDto update(Long id, ServiceOfferDto dto) {
        ServiceOffer entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Service not found"));
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setDurationMinutes(dto.getDurationMinutes());
        entity.setPrice(dto.getPrice());
        entity.setPhotoUrl(dto.getPhotoUrl());
        entity.setCategory(dto.getCategory());
        entity.setAvailability(dto.getAvailability());
        entity.setActive(dto.getActive());
        return ServiceOfferMapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
