package com.jalasoft.Tour.infrastructure.persistence.adapter;

import com.jalasoft.Tour.domain.adapter.TourRepositoryAdapter;
import com.jalasoft.Tour.domain.entity.Tour;
import com.jalasoft.Tour.infrastructure.aggregate.TourAggregate;
import com.jalasoft.Tour.infrastructure.persistence.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Giordano Bortolini
 */
@Component
public class TourPostgresRepository implements TourRepositoryAdapter {

  private final TourRepository repository;

  @Autowired
  public TourPostgresRepository(TourRepository repository) {
    this.repository = repository;
  }


  @Override
  public Tour save(Tour tour) {
    TourAggregate tourAggregate = TourAggregate.fromDomain(tour);
    return repository.save(tourAggregate).toDomain();
  }
}
