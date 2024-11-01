package com.jalasoft.Tour.infrastructure.aggregate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Giordano Bortolini
 */
@Getter
@Setter
@Entity
@Table(name = "tour_extreme")
@NoArgsConstructor
public class TourExtremeAggregate extends BaseTourAggregate {

    // do nothing
    //localhost../tour/aklds_tourPackageId_f4564/filter?tourId=aaaaa

}
