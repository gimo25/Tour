package com.jalasoft.Tour.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jalasoft.Tour.application.dto.DrinkItem;
import com.jalasoft.Tour.application.dto.FoodItem;
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

  @Test
  public void testVarargs() {

    assertEquals("1 2 3 4 5 6 ...n", getAllArgs());
  }

  private String getAllArgs() {

    return processMessage("1", "2", "3", "4","5", "6", "...n");
    /*String[] args = {"1", "2", "3", "4", "...n"};
    return processMessage(args);*/
   // return processMessage("1", "2", "3", "4", "5","...n");
  }

  private String processMessage(String... args) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < args.length; i++) {
      builder.append(args[i]).append(" ");
    }
    return builder.toString().trim();
  }

  private String processMessage(String a, String b, String c, String d, String e, String f) {
    return STR."\{a} \{b} \{c} \{d} \{e} \{f}";
  }
}
