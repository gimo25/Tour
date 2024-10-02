package com.jalasoft.Tour.service;

import com.jalasoft.Tour.dto.RatingDto;
import com.jalasoft.Tour.entity.TourEntity;
import com.jalasoft.Tour.entity.TourRatingEntity;
import com.jalasoft.Tour.repository.TourRatingRepository;
import com.jalasoft.Tour.repository.TourRepository;
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
    TourEntity tourEntity = tourRepository.findById(tourId).orElseThrow(() -> new RuntimeException("Tour id not found."));
    ratingDto.setTourId(tourId);
    ratingDto.setTour(tourEntity.toDTO());
    TourRatingEntity tourRatingEntity = new TourRatingEntity(ratingDto);
    ratingRepository.save(tourRatingEntity);

    return tourRatingEntity.toDTO();
  }
}
