package com.jalasoft.Tour.infrastructure.aggregate;

import com.jalasoft.Tour.application.dto.TourDTO;
import com.jalasoft.Tour.domain.entity.Tour;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Giordano Bortolini
 */
@Getter
@Setter
@Entity
@Table(name = "tour")
@NoArgsConstructor
public class TourAggregate {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Column(name = "title")
  private String title;
  @Column(name = "description")
  private String description;
  @Column(name = "duration")
  private String duration;
  @Column(name = "price")
  private Integer price;
  @Column(name = "nicePlace")
  private boolean nicePlace;
  @ManyToOne
  @JoinColumn(name = "code")
  private TourPackageAggregate tourPackage;

  public TourAggregate(String title, Integer price, Boolean isNicePlace) {
    this.title = title;
    this.price = price;
    this.nicePlace = isNicePlace;
  }

  public TourAggregate(TourDTO tour) {

    this.title = tour.getTitle();
    this.description = tour.getDescription();
    this.duration = tour.getDuration();
    this.price = (int) Math.round(tour.getPrice());
    this.nicePlace = tour.getNicePlace();
  }

  public static TourAggregate fromDomain(Tour tour) {
    TourAggregate tourAggregate = new TourAggregate();
    tourAggregate.setTitle(tour.getTitle());
    tourAggregate.setDuration(tour.getDuration());
    tourAggregate.setPrice(tour.getPrice());
    tourAggregate.setNicePlace(tour.isNicePlace());
    return tourAggregate;
  }

  public TourDTO toDTO() {
    TourDTO tourDTO = new TourDTO();
    tourDTO.setId(this.id.toString());
    tourDTO.setTitle(this.title);
    tourDTO.setDescription(this.description);
    tourDTO.setPrice((double) Math.round(this.price));
    return tourDTO;
  }

  public Tour toDomain() {

    return Tour.builder().id(id)
        .description(description).price(price).nicePlace(nicePlace).title(title).build();
  }
}
