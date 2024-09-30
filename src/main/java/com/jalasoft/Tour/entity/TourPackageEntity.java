package com.jalasoft.Tour.entity;

import com.jalasoft.Tour.dto.TourPackageDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Giordano Bortolini
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tour_package")
public class TourPackageEntity {

  @Id
  private String code;

  @Column(name = "name")
  private String name;
  @Column(name = "start_date")
  private LocalDate startDate;
  @Column(name = "end_date")
  private LocalDate endDate;

  @Column(name = "price")
  private double price;

  public TourPackageEntity(String code, String name, double price) {
    this.code = code;
    this.name = name;
    this.price = price;
  }

  public TourPackageDTO toDTO() {
    TourPackageDTO dto = new TourPackageDTO();
    dto.setCode(this.code);
    dto.setName(this.name);
    dto.setStartDate(this.startDate);
    dto.setEndDate(this.endDate);

    return dto;
  }
}
