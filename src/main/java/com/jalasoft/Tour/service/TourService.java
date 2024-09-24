package com.jalasoft.Tour.service;

import com.jalasoft.Tour.entity.TourEntity;
import com.jalasoft.Tour.repository.TourRepository;

/**
 * @author Giordano Bortolini
 */

public class TourService {
  private TourRepository tourRepository;

  public TourService(TourRepository tourRepository) {
    this.tourRepository = tourRepository;
    createTour("Colombia", 750, true);
    createTour( "Day Spa Package", 200, false);
    createTour("Monterey to Santa Barbara Tour", 550, false);
    createTour("Kids L.A. Tour", 100, true);
    createTour("Islands of the Blue Dolphins Tour", 200, true);
    createTour("Endangered Species Expedition", 250, true);
  }
  public TourEntity createTour(String title, Integer price, Boolean nicePlace) {
    return tourRepository.save(new TourEntity(title, price, nicePlace));
  }
}
