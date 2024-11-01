package com.jalasoft.Tour.infrastructure.persistence.repository;

import com.jalasoft.Tour.infrastructure.aggregate.TourViewAggregate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Giordano Bortolini
 */
@Repository
public interface TourViewRepository extends MongoRepository<TourViewAggregate, String> {

}
