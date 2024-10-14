package com.jalasoft.Tour.infrastructure.persistence.adapter;

import com.jalasoft.Tour.domain.adapter.TourPackageAdapter;
import com.jalasoft.Tour.domain.entity.TourPackage;
import com.jalasoft.Tour.infrastructure.aggregate.TourPackageAggregate;
import com.jalasoft.Tour.infrastructure.persistence.repository.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Giordano Bortolini
 */

public class TourPackagePostgresRepository implements TourPackageAdapter {

  private final TourPackageRepository repository;

  @Autowired
  public TourPackagePostgresRepository(TourPackageRepository repository) {
    this.repository = repository;
  }

  public TourPackage save(TourPackage tour) {
    TourPackageAggregate tourPackageAggregate = TourPackageAggregate.fromDomain(tour);
    return repository.save(tourPackageAggregate).toDomain();
  }
}
