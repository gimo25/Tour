package com.jalasoft.Tour.infrastructure.persistence.repository;

import com.jalasoft.Tour.infrastructure.aggregate.TourAggregate;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Giordano Bortolini
 */
@Repository
public interface TourRepository extends JpaRepository<TourAggregate, UUID> {

}
