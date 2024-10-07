package com.jalasoft.Tour.application.service;

import com.jalasoft.Tour.infrastructure.aggregate.TourAggregate;
import com.jalasoft.Tour.infrastructure.persistence.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Giordano Bortolini
 */
@Service
@Deprecated
public class AgentService {
  private final TourRepository tourRepository;

  @Autowired
  public AgentService(TourRepository tourRepository) {
    this.tourRepository = tourRepository;
  }
  public void displayTours() {
    tourRepository.findAll().stream().map(TourAggregate::getTitle).forEach(System.out::println);
  }

  public void displayToursBy(Boolean isNice) {
    /*tourRepository.findByType(isNice).stream().map(TourEntity::getTitle)
        .forEach(System.out::println);*/
  }

}
