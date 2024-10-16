package com.jalasoft.Tour.application.dto;

import lombok.Data;

/**
 * @author Giordano Bortolini
 */

@Data
public class ClientRatingDto {

  private Long id;


  private String name;

  private String lastName;

  private String phone;

  private RatingDto rating;

}
