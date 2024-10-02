package com.jalasoft.Tour.repository;

import com.jalasoft.Tour.entity.TourRatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Giordano Bortolini
 */

@Repository
public interface TourRatingRepository extends JpaRepository<TourRatingEntity, Integer> {

}
