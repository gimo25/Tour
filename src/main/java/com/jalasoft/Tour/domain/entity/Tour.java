package com.jalasoft.Tour.domain.entity;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Giordano Bortolini
 */
@Getter
@Builder
public class Tour {

  private UUID id;
  private String title;
  private String description;
  private String duration;
  private Integer price;
  private boolean nicePlace;
  private TourPackage tourPackage;
}
