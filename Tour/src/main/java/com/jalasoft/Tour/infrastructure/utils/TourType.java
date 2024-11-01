package com.jalasoft.Tour.infrastructure.utils;

import lombok.AllArgsConstructor;

import lombok.Getter;

/**
 * @author Giordano Bortolini
 */
@Getter
@AllArgsConstructor
public enum TourType {
  SIMPLE("Simple"),
  EXTREME("Extreme");

  private final String type;
  public static TourType getByType(String type) {

    TourType foundType = null;
    for (TourType tourType : values()) {
      if (tourType.getType().equalsIgnoreCase(type)) {
        foundType = tourType;
        break;
      }
    }
    return foundType;
  }
}
