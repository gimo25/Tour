package com.jalasoft.Tour.infrastructure.persistence.repository;

import com.jalasoft.Tour.infrastructure.aggregate.TourRatingAggregate;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Giordano Bortolini
 */

@Repository
public interface TourRatingRepository extends JpaRepository<TourRatingAggregate, UUID> {

}
