package com.jalasoft.Tour.service;

import com.jalasoft.Tour.application.dto.TourDTO;
import com.jalasoft.Tour.application.dto.TourPackageDTO;
import com.jalasoft.Tour.infrastructure.aggregate.TourAggregate;
import com.jalasoft.Tour.infrastructure.aggregate.TourPackageAggregate;
import com.jalasoft.Tour.infrastructure.persistence.repository.TourPackageRepository;
import com.jalasoft.Tour.infrastructure.persistence.repository.TourRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Giordano Bortolini
 */
@Service
@Transactional
public class TourPackageService {


  public TourPackageRepository repository;
  public TourRepository tourRepository;

  @Autowired
  public TourPackageService(TourPackageRepository repository,TourRepository tourRepository) {

    this.repository = repository;
    this.tourRepository = tourRepository;
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

  public void createTourPackage(TourPackageDTO packageDTO) {

    List<TourAggregate> tourList = packageDTO.getTours().stream().map(TourDTO::toDomain)
        .map(TourAggregate::fromDomain).toList();
    tourRepository.saveAll(tourList);
    TourPackageAggregate tourPackage = TourPackageAggregate.fromDomain(packageDTO.toDomain());
    if (packageDTO.getCode() == null) {
      throw new RuntimeException();
    }
    repository.save(tourPackage);
  }
}
