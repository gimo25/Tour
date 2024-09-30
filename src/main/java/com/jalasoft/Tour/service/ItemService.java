package com.jalasoft.Tour.service;

import com.jalasoft.Tour.dto.Item;

import org.springframework.stereotype.Service;

/**
 * @author Giordano Bortolini
 */
@Service
public class ItemService {

  public String getDetails(Item item) {
      return STR."Breakfast is \{item.getDescription()}.";
  }
}
