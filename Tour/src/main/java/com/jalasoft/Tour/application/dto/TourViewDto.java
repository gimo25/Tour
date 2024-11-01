package com.jalasoft.Tour.application.dto;

import lombok.Data;

/**
 * @author Giordano Bortolini
 */
@Data
public class TourViewDto {
  private String id;

  private String fileName;
  private byte[] data;
}
