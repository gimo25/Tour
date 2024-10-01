package com.jalasoft.Tour.repository;

import com.jalasoft.Tour.entity.TourPackageEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author Giordano Bortolini
 */
@Repository
@RepositoryRestResource(path = "tour-package")
public interface TourPackageRepository extends JpaRepository<TourPackageEntity, String> {

  Optional<TourPackageEntity> findByName(String name);

  TourPackageEntity findFirstByOrderByPriceAsc();
}
