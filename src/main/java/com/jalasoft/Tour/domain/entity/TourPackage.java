package com.jalasoft.Tour.domain.entity;

import java.time.LocalDate;
import lombok.Builder;

/**
 * @author Giordano Bortolini
 */
@Builder
public class TourPackage {
  private String code;
  private String name;
  private LocalDate startDate;
  private LocalDate endDate;
  private Double price;

  public Double calculateBestPriceByLocation(String location) {
    return 2d;
  }
}
