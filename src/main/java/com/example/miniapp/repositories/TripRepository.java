package com.example.miniapp.repositories;

import com.example.miniapp.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    // Find trips between two tripDate values
    List<Trip> findByTripDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Find all trips for a specific captain
    List<Trip> findByCaptainId(Long captainId);
}
