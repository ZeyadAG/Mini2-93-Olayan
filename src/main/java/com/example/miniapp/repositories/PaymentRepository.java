package com.example.miniapp.repositories;

import com.example.miniapp.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find payments by trip ID
    List<Payment> findByTripId(Long tripId);

    // Find payments above a set threshold
    List<Payment> findByAmountGreaterThan(Double amountThreshold);
}
