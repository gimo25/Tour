package com.jalasoft.Tour.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Giordano Bortolini
 */
public class ItemServiceTest {

  @Test
  public void testGetFoodItemDetailsForBreakfastType() {
    ItemService itemService = new ItemService();

    String result = itemService.getDetails(new FoodItem("breakfast"));

    assertEquals("Breakfast is Pancakes with honey.", result);
  }

  @Test
  public void testGetDrinkItemDetailsForBreakfastType() {
    ItemService itemService = new ItemService();

    String result = itemService.getDetails(new DrinkItem("breakfast"));

    assertEquals("Breakfast is Orange juice with milk/coffee.", result);
  }
}
