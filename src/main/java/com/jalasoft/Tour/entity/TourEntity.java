package com.jalasoft.Tour.entity;

/**
 * @author Giordano Bortolini
 */
public class TourEntity {

  private String title;
  private Integer price;

  private boolean nicePlace;

  public TourEntity(String title, Integer price, Boolean isNicePlace) {
    this.title = title;
    this.price = price;
    this.nicePlace = isNicePlace;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public boolean isNicePlace() {
    return nicePlace;
  }
}
