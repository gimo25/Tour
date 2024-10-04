package com.jalasoft.Tour.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Giordano Bortolini
 */
public class TourServiceTest {

  @Test
  public void givenValues_whenRequestTourDescription_thenHaveStringFormat() {
    var tourResponse = new TourService(null);

    assertEquals(
        "The travel to Medellin is in the range ($100 & $300) with a final price of $250.75",
        tourResponse.getTourMessageByPriceRange(100, 300));
  }
}
