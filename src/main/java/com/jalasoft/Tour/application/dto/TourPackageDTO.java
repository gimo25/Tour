package com.jalasoft.Tour.application.dto;

import com.jalasoft.Tour.domain.entity.TourPackage;
import com.jalasoft.Tour.infrastructure.aggregate.TourPackageAggregate;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Giordano Bortolini
 */
@Data
@NoArgsConstructor
public class TourPackageDTO {

  private String code;
  private String name;
  private LocalDate startDate;
  private LocalDate endDate;
  private List<TourDTO> tours;

  public TourPackage toDomain() {
    return TourPackage.builder().code(code).name(name).startDate(startDate).build();
  }
}
