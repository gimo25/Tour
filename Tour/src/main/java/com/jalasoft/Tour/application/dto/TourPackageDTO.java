package com.jalasoft.Tour.application.dto;

import com.jalasoft.Tour.domain.entity.TourPackage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Giordano Bortolini
 */
@Data
@NoArgsConstructor
public class TourPackageDTO implements IExportable {

  private String code;
  private String name;
  private LocalDate startDate = LocalDate.now();
  private LocalDate endDate = LocalDate.now();
  private List<TourDTO> tours = new ArrayList<>();

  public TourPackage toDomain() {
    return TourPackage.builder().code(code).name(name).startDate(startDate).endDate(endDate).build();
  }

  @Override
  public List<String> createHeader() {
    return Arrays.asList("Code", "Name", "Start Date", "End Date", "Tour - Title", "Tour - Price");
  }

  @Override
  public List<String> createRow() {
    if (startDate == null) {
      startDate = LocalDate.now();
    }
    if (endDate == null) {
      endDate = LocalDate.now();
    }

    return Arrays.asList(code, name, startDate.toString(), endDate.toString(),
        tours.getFirst().getTitle(), tours.getFirst().getPrice().toString());
  }
}
