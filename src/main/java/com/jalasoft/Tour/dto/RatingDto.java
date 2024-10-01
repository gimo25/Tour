package com.jalasoft.Tour.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.UUID;
import lombok.Data;

/**
 * @author Giordano Bortolini
 */
@Data
public class RatingDto {

  private Integer score;
  private String comment;
  private UUID tourId;

  @JsonProperty(access = Access.READ_ONLY)
  private TourDTO tour;

}
