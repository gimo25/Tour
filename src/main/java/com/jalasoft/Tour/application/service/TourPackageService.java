package com.jalasoft.Tour.application.service;

import com.jalasoft.Tour.application.dto.TourPackageDTO;
import com.jalasoft.Tour.infrastructure.aggregate.TourPackageAggregate;
import com.jalasoft.Tour.infrastructure.persistence.repository.TourPackageRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Giordano Bortolini
 */
@Service
public class TourPackageService {


  public TourPackageRepository repository;

  @Autowired
  public TourPackageService(TourPackageRepository repository) {

    this.repository = repository;
    createTourPackage("TC1", "Travel to Colombia", 1500);
    createTourPackage("TB1", "Travel to Bolivia", 2300);
    createTourPackage("TM1", "Travel to Mexico",3100);
  }

  public TourPackageAggregate createTourPackage(String code, String name, double price) {
    TourPackageAggregate entity = repository.save(new TourPackageAggregate(code, name, price));
    return entity;
  }


  public TourPackageDTO findByPackageName(String name) {
    Optional<TourPackageAggregate> packageEntity =repository.findByName(name);

    return packageEntity.map(TourPackageAggregate::toDTO).orElse(null);
  }

  public String getLowerPricePackageDescription() {
    TourPackageAggregate packageEntity = repository.findFirstByOrderByPriceAsc();
    return STR."The tour with the lowest price is \{packageEntity.toDTO().getCode()}.";
  }
}
