package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Rating;
import com.example.demo.repositories.RatingRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating addRating(Rating rating) {
        if (rating.getRatingDate() == null) {
            rating.setRatingDate(LocalDateTime.now());
        }
        return ratingRepository.save(rating);
    }

     public Rating updateRating(String id, Rating updated) {

        return ratingRepository.findById(id)
                .map(existing -> { 
                    if (updated.getScore()   != null) existing.setScore(updated.getScore());
                    if (updated.getComment() != null) existing.setComment(updated.getComment());
                    existing.setRatingDate(LocalDateTime.now());
                    return ratingRepository.save(existing);
                })
                .orElseGet(() -> {  
                    updated.setId(id);                 
                    if (updated.getRatingDate() == null)
                        updated.setRatingDate(LocalDateTime.now());
                    return ratingRepository.save(updated);
                });
    }

    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }

    public List<Rating> getRatingsByEntity(Long entityId, String entityType) {
        return ratingRepository.findByEntityIdAndEntityType(entityId, entityType);
    }

    public List<Rating> findRatingsAboveScore(int minScore) {
        return ratingRepository.findByScoreGreaterThan(minScore);
    }
}
