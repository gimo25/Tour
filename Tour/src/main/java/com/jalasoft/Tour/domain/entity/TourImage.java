package com.jalasoft.Tour.domain.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Giordano Bortolini
 */
@Data
@Builder
public class TourImage {

  private String id;
  private String fileName;
  private byte[] data;
}
