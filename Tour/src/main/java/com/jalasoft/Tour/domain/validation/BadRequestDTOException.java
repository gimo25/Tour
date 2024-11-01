package com.jalasoft.Tour.domain.validation;

import com.jalasoft.Tour.domain.validation.dto.ErrorDetail;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author Giordano Bortolini
 */
@Getter
@Setter
@AllArgsConstructor
public class BadRequestDTOException extends RuntimeException {
  private final String moduleName;
  private final List<ErrorDetail> errorDetails;
  private final HttpStatus status;
}
