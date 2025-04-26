package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find payments by trip ID
    List<Payment> findByTripId(Long tripId);

    // Find payments above a set threshold
    List<Payment> findByAmountGreaterThan(Double amountThreshold);
}
