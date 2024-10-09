package com.jalasoft.Tour.infrastructure.aggregate;

import com.jalasoft.Tour.application.dto.TourDTO;
import com.jalasoft.Tour.domain.entity.Tour;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Giordano Bortolini
 */
@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseTourAggregate {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  protected UUID id;
  @Column(name = "title")
  protected String title;
  @Column(name = "description")
  protected String description;
  @Column(name = "duration")
  protected String duration;
  @Column(name = "price")
  protected Integer price;

  @ManyToOne
  @JoinColumn(name = "code")
  private TourPackageAggregate tourPackage;

  public BaseTourAggregate(String title, Integer price) {
    this.title = title;
    this.price = price;
  }

  public BaseTourAggregate(TourDTO tour) {

    this.title = tour.getTitle();
    this.description = tour.getDescription();
    this.duration = tour.getDuration();
    this.price = (int) Math.round(tour.getPrice());
  }

  public Tour toDomain() {
    return Tour.builder().id(id)
        .description(description).price(price).title(title).build();
  }
}
