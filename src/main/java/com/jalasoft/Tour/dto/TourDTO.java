package com.jalasoft.Tour.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Giordano Bortolini
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
