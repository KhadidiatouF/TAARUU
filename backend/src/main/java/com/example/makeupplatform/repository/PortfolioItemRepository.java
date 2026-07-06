package com.example.makeupplatform.repository;

import com.example.makeupplatform.entity.PortfolioItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Long> {
}
