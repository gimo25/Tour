package com.jalasoft.Tour.repository;

import com.jalasoft.Tour.entity.TourEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Giordano Bortolini
 */
@Repository
public interface TourRepository extends JpaRepository<TourEntity, UUID> {

}
