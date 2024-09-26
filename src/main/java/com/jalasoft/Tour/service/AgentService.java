package com.jalasoft.Tour.service;

import com.jalasoft.Tour.entity.TourEntity;
import com.jalasoft.Tour.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Giordano Bortolini
 */
@Service
public class AgentService {
  private final TourRepository tourRepository;

  @Autowired
  public AgentService(TourRepository tourRepository) {
    this.tourRepository = tourRepository;
  }
  public void displayTours() {
    tourRepository.findAll().stream().map(TourEntity::getTitle).forEach(System.out::println);
  }

  public void displayToursBy(Boolean isNice) {
    tourRepository.findByType(isNice).stream().map(TourEntity::getTitle)
        .forEach(System.out::println);
  }

}
