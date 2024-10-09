package com.jalasoft.Tour.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

  @Size(min = 0, max = 40)
  private String title;
  private String description;
  @NotNull @NotBlank
  private String duration;

  @Min(0) @Max(9999)
  private Double price;
  @JsonProperty("isNice")
  @NotNull
  private Boolean nicePlace;

}
