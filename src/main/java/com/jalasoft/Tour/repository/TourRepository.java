package com.jalasoft.Tour.repository;

import com.jalasoft.Tour.entity.TourEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Giordano Bortolini
 */

public class TourRepository {
  private final List<TourEntity> tours = new ArrayList<>();

  public TourRepository() {
  }

  public TourEntity save(TourEntity tour) {
    if (!tours.contains(tour)) {
      tours.add(tour);
    }
    return tour;
  }

  public List<TourEntity> findAll() {
    return tours;
  }

  public List<TourEntity> findByType(Boolean isNicePlace) {
    return tours.stream().filter(t -> t.isNicePlace() == isNicePlace).toList();
  }
}
