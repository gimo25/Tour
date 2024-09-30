package com.jalasoft.Tour.service;

import com.jalasoft.Tour.dto.TourPackageDTO;
import com.jalasoft.Tour.entity.TourPackageEntity;
import com.jalasoft.Tour.repository.TourPackageRepository;
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
    createTourPackage("TC1", "Travel to Colombia");
    createTourPackage("TB1", "Travel to Bolivia");
    createTourPackage("TM1", "Travel to Mexico");
  }

  public TourPackageEntity createTourPackage(String code, String name) {
    TourPackageEntity entity = repository.save(new TourPackageEntity(code, name));
    return entity;
  }


  public TourPackageDTO findByPackageName(String name) {
    Optional<TourPackageEntity> packageEntity =repository.findByName(name);

    return packageEntity.map(TourPackageEntity::toDTO).orElse(null);
  }

}
