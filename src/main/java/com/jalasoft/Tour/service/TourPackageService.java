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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Giordano Bortolini
 */
@Service
@Slf4j
@Transactional
public class TourPackageService {

  public TourPackageRepository repository;
  public TourRepository tourRepository;

  @Autowired
  public TourPackageService(TourPackageRepository repository,TourRepository tourRepository) {
    this.repository = repository;
    this.tourRepository = tourRepository;
  }

  public TourPackageAggregate createTourPackage(String code, String name, double price) {
    return repository.save(new TourPackageAggregate(code, name, price));
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

    if (log.isErrorEnabled()) {
      System.out.println("COPY - Create Tour Package " + packageDTO.toString());
      log.error("Create Tour Package {}", packageDTO);
    }

    List<TourAggregate> tourList = packageDTO.getTours().stream().map(TourDTO::toDomain)
        .map(TourAggregate::fromDomain).toList();
    tourRepository.saveAll(tourList);
    TourPackageAggregate tourPackage = TourPackageAggregate.fromDomain(packageDTO.toDomain());
    if (packageDTO.getCode() == null) {
      log.error("Error trying to create Tour Package {}", packageDTO);
      throw new RuntimeException();
    }
    repository.save(tourPackage);
  }

  public List<TourPackageDTO> findAll() {
    return repository.findAll().stream().map(TourPackageAggregate::toDTO).toList();
  }
}
