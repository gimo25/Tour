package com.jalasoft.Tour.entity;

import com.jalasoft.Tour.dto.RatingDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.NoArgsConstructor;

/**
 * @author Giordano Bortolini
 */
@Entity
@NoArgsConstructor
public class TourRatingEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  public long id;
  @Column(name = "score")
  private Integer score;
  @Column(name = "comment")
  private String comment;
  @Column(name = "tour_id")
  private UUID tourId;
  public TourRatingEntity(RatingDto ratingDto) {
    this.score = ratingDto.getScore();
    this.comment = ratingDto.getComment();
    this.tourId = ratingDto.getTourId();
  }

  public RatingDto toDTO() {
    RatingDto rating = new RatingDto();
    rating.setTourId(tourId);
    rating.setComment(comment);
    rating.setScore(score);
    return rating;
  }
}
