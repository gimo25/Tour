package com.jalasoft.Tour.service;

import com.jalasoft.Tour.application.dto.RatingDto;
import com.jalasoft.Tour.infrastructure.aggregate.TourAggregate;
import com.jalasoft.Tour.infrastructure.aggregate.TourRatingAggregate;
import com.jalasoft.Tour.infrastructure.persistence.repository.TourRatingRepository;
import com.jalasoft.Tour.infrastructure.persistence.repository.TourRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Giordano Bortolini
 */
@Service
public class TourRatingService {

  @Autowired
  private TourRatingRepository ratingRepository;
  @Autowired
  private TourRepository tourRepository;

  public RatingDto createTourRating(UUID tourId, RatingDto ratingDto) {
    TourAggregate tourEntity = tourRepository.findById(tourId).orElseThrow(() -> new RuntimeException("Tour id not found."));
    ratingDto.setTourId(tourId);
    ratingDto.setTour(tourEntity.toDTO());
    TourRatingAggregate tourRatingEntity = new TourRatingAggregate(ratingDto);
    ratingRepository.save(tourRatingEntity);

    return tourRatingEntity.toDTO();
  }
}
