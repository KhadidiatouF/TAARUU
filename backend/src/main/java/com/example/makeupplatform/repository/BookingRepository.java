package com.example.makeupplatform.repository;

import com.example.makeupplatform.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
