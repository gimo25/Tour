package com.jalasoft.Tour.infrastructure.persistence.repository;

import com.jalasoft.Tour.infrastructure.aggregate.TourPackageAggregate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author Giordano Bortolini
 */
@Repository
@RepositoryRestResource(path = "tour-package")
public interface TourPackageRepository extends JpaRepository<TourPackageAggregate, String> {

  Optional<TourPackageAggregate> findByName(String name);

  TourPackageAggregate findFirstByOrderByPriceAsc();
}
