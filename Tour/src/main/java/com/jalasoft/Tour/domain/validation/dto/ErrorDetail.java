package com.jalasoft.Tour.domain.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Giordano Bortolini
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorDetail {

  private String fieldId;
  private String errorMessage;

}
