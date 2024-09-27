package com.jalasoft.Tour.service;

import com.jalasoft.Tour.dto.TourDTO;
import com.jalasoft.Tour.entity.TourEntity;
import com.jalasoft.Tour.record.pattern.AdultTicket;
import com.jalasoft.Tour.record.pattern.ChildTicket;
import com.jalasoft.Tour.record.pattern.Ticket;
import com.jalasoft.Tour.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Giordano Bortolini
 */

@Service
public class TourService {

  private final TourRepository tourRepository;

  @Autowired
  public TourService(TourRepository tourRepository) {
    this.tourRepository = tourRepository;
    createTour("Colombia", 750, true);
    createTour("Day Spa Package", 200, false);
    createTour("Monterey to Santa Barbara Tour", 550, false);
    createTour("Kids L.A. Tour", 100, true);
    createTour("Islands of the Blue Dolphins Tour", 200, true);
    createTour("Endangered Species Expedition", 250, true);
  }

  public TourDTO createTour(TourDTO tour) {
    TourEntity entity = tourRepository.save(new TourEntity(tour));
    tour.setId(entity.getId().toString());
    return tour;
  }

  @Deprecated
  public TourEntity createTour(String title, Integer price, Boolean nicePlace) {
    return tourRepository.save(new TourEntity(title, price, nicePlace));
  }

  public String ticketMessage(Ticket ticket) {

    if (ticket instanceof AdultTicket(int id, String description)) {
      return STR."\{id} \{description}";
    }
    if (ticket instanceof ChildTicket(int id, String description)) {
      return STR."\{id} \{description}";
    }
    return "";
  }

  public String getTourMessageByPriceRange(int min, int max) {
    final float price = 250.75f;
    return StringTemplate.STR."The travel to Medellin is in the range ($\{min} & $\{max}) with a final price of $\{price}";
  }
}
