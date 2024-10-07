package com.jalasoft.Tour.application.dto;

/**
 * @author Giordano Bortolini
 */
public record FoodItem(String description) implements Item {

  @Override
  public String getDescription() {
    return description;
  }
}
