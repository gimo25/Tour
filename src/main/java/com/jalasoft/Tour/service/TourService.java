package com.jalasoft.Tour.service;

import com.jalasoft.Tour.application.dto.TourDTO;
import com.jalasoft.Tour.application.validation.TourDtoValidation;
import com.jalasoft.Tour.domain.entity.Tour;
import com.jalasoft.Tour.infrastructure.aggregate.TourAggregate;
import com.jalasoft.Tour.infrastructure.persistence.adapter.TourPostgresRepository;
import com.jalasoft.Tour.infrastructure.utils.TourType;
import com.jalasoft.Tour.record.pattern.AdultTicket;
import com.jalasoft.Tour.record.pattern.ChildTicket;
import com.jalasoft.Tour.record.pattern.Ticket;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Giordano Bortolini
 */

@Service
public class TourService {

  private final TourPostgresRepository tourRepository;

  @Autowired
  public TourService(TourPostgresRepository tourRepository) {
    this.tourRepository = tourRepository;
    createTour("Colombia", 750, true);
    createTour("Day Spa Package", 200, false);
    createTour("Monterey to Santa Barbara Tour", 550, false);
    createTour("Kids L.A. Tour", 100, true);
    createTour("Islands of the Blue Dolphins Tour", 200, true);
    createTour("Endangered Species Expedition", 250, true);
  }

  public TourDTO createTour(TourDTO tour) {
    new TourDtoValidation().validate(tour);
    TourAggregate aggregate = new TourAggregate(tour);
    Tour entity = tourRepository.save(aggregate.toDomain());
    tour.setId(entity.getId().toString());
    return tour;
  }

  @Deprecated
  public TourAggregate createTour(String title, Integer price, Boolean nicePlace) {
    TourAggregate aggregate = new TourAggregate(title, price, nicePlace);
    Tour entity = tourRepository.save(aggregate.toDomain());
    return TourAggregate.fromDomain(entity);
  }

  public List<TourDTO> findByTourType(TourType type) {
    List<Tour> tours = new ArrayList<>();
    if (type != null) {
      switch (type) {
        case EXTREME -> tours = tourRepository.getExtremeTours();
        default -> tours = tourRepository.getTours();
      }
    }
    return tours.stream().map(TourDTO::fromDomain).toList();
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
