package com.jalasoft.Tour.infrastructure.persistence.adapter;

import com.jalasoft.Tour.application.dto.TourDTO;
import com.jalasoft.Tour.domain.adapter.TourRepositoryAdapter;
import com.jalasoft.Tour.domain.entity.Tour;
import com.jalasoft.Tour.infrastructure.aggregate.TourAggregate;
import com.jalasoft.Tour.infrastructure.aggregate.TourExtremeAggregate;
import com.jalasoft.Tour.infrastructure.persistence.repository.TourExtremeRepository;
import com.jalasoft.Tour.infrastructure.persistence.repository.TourRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Giordano Bortolini
 */
@Component
public class TourPostgresRepository implements TourRepositoryAdapter {

  private final TourRepository repository;
  private final TourExtremeRepository extremeRepository;

  @Autowired
  public TourPostgresRepository(
      TourRepository repository, TourExtremeRepository extremeRepository) {
    this.repository = repository;
    this.extremeRepository = extremeRepository;
  }

  @Override
  public Tour save(Tour tour) {
    TourAggregate tourAggregate = TourAggregate.fromDomain(tour);
    return repository.save(tourAggregate).toDomain();
  }

  public List<Tour> getExtremeTours() {
    return extremeRepository.findAll().stream().map(TourExtremeAggregate::toDomain).toList();
  }

  public List<Tour> getTours() {
    return repository.findAll().stream().map(TourAggregate::toDomain).collect(Collectors.toList());
  }
}
