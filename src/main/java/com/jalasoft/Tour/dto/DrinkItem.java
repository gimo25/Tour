package com.jalasoft.Tour.dto;

/**
 * @author Giordano Bortolini
 */
public record DrinkItem(String description) implements Item {

  @Override
  public String getDescription() {
    return description;
  }
}
