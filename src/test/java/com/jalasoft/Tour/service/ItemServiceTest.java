package com.jalasoft.Tour.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jalasoft.Tour.dto.DrinkItem;
import com.jalasoft.Tour.dto.FoodItem;
import org.junit.jupiter.api.Test;

/**
 * @author Giordano Bortolini
 */
public class ItemServiceTest {

  @Test
  public void testGetFoodItemDetailsForBreakfastType() {
    ItemService itemService = new ItemService();

    String result = itemService.getDetails(new FoodItem("Pancakes with honey"));

    assertEquals("Breakfast is Pancakes with honey.", result);
  }

  @Test
  public void testGetDrinkItemDetailsForBreakfastType() {
    ItemService itemService = new ItemService();

    String result = itemService.getDetails(new DrinkItem("Orange juice with milk/coffee"));

    assertEquals("Breakfast is Orange juice with milk/coffee.", result);
  }
}
