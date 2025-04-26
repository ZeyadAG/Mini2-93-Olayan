package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Captain;

import java.util.List;
import java.util.Optional;

public interface CaptainRepository extends JpaRepository<Captain, Long> {

    // Find captains with average rating above a threshold
    List<Captain> findByAvgRatingScoreGreaterThan(Double ratingThreshold);

    // Find captain by license number
    Optional<Captain> findByLicenseNumber(String licenseNumber);
}
