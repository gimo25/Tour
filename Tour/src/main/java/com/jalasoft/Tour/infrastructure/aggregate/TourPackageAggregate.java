package com.jalasoft.Tour.infrastructure.aggregate;

import com.jalasoft.Tour.application.dto.TourPackageDTO;
import com.jalasoft.Tour.domain.entity.TourPackage;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
public class TourPackageAggregate {

  @Id
  private String code;

  @Column(name = "name")
  private String name;
  @Column(name = "start_date")
  private LocalDate startDate;
  @Column(name = "end_date")
  private LocalDate endDate;

  @Column(name = "price")
  private Double price;

  @OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<TourAggregate> tours;

  public TourPackageAggregate(String code, String name, double price) {
    this.code = code;
    this.name = name;
    this.price = price;
    this.tours = new ArrayList<>();
  }

  public TourPackageDTO toDTO() {
    TourPackageDTO dto = new TourPackageDTO();
    dto.setCode(this.code);
    dto.setName(this.name);
    dto.setStartDate(this.startDate);
    dto.setEndDate(this.endDate);
    dto.setTours(this.tours.stream().map(TourAggregate::toDTO).toList());

    return dto;
  }

  public static TourPackageAggregate fromDomain(TourPackage tour) {
    TourPackageAggregate tourAggregate = new TourPackageAggregate();
    tourAggregate.setCode(tour.getCode());
    tourAggregate.setName(tour.getName());
    tourAggregate.setPrice(tour.getPrice());
    tourAggregate.setStartDate(tour.getStartDate());
    return tourAggregate;
  }

  public TourPackage toDomain() {
    return TourPackage.builder().price(this.price).code(code).name(name).startDate(startDate)
        .build();
  }
}
