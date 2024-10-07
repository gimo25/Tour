package com.jalasoft.Tour.application.dto;

import java.time.LocalDate;
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
}
