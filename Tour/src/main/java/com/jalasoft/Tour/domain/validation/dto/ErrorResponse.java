package com.jalasoft.Tour.domain.validation.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Giordano Bortolini
 */
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
  private String field;
  private List<ErrorDetail> errorDetails;

}
