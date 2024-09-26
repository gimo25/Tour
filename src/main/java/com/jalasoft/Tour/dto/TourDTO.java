package com.jalasoft.Tour.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Giordano Bortolini
 */
@Data
@AllArgsConstructor
public class TourDTO {

  @JsonProperty("tourId")
  private String id;
  private String title;
  private String description;
  private String duration;
  private Double price;
  @JsonProperty("isNice")
  private Boolean nicePlace;

}
