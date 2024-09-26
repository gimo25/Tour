package com.jalasoft.Tour.entity;

import com.jalasoft.Tour.dto.TourDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
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
public class TourEntity {

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
  private TourPackageEntity tourPackage;

  public TourEntity(String title, Integer price, Boolean isNicePlace) {
    this.title = title;
    this.price = price;
    this.nicePlace = isNicePlace;
  }

  public TourEntity(TourDTO tour) {

    this.title = tour.getTitle();
    this.description = tour.getDescription();
    this.duration = tour.getDuration();
    this.price = (int) Math.round(tour.getPrice());
    this.nicePlace = tour.getNicePlace();
  }
}
