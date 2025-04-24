package com.example.miniapp.services;

import com.example.miniapp.models.Rating;
import com.example.miniapp.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Rating updateRating(String id, Rating updatedRating) {

        Optional<Rating> maybeExisting = ratingRepository.findById(id);
        if (maybeExisting.isEmpty()) {
            return null;
        }

        Rating existing = maybeExisting.get();

        if (updatedRating.getScore() != null) {
            existing.setScore(updatedRating.getScore());
        }
        if (updatedRating.getComment() != null) {
            existing.setComment(updatedRating.getComment());
        }
        existing.setRatingDate(LocalDateTime.now());

        return ratingRepository.save(existing);
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
