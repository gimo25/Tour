package com.jalasoft.Tour.configuration.handler;

import com.jalasoft.Tour.domain.validation.dto.ErrorDetail;
import com.jalasoft.Tour.domain.validation.dto.ErrorResponse;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Giordano Bortolini
 */
@ControllerAdvice
public class BadRequestExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handlerExceptionValidator(
      MethodArgumentNotValidException ex) {

    List<ErrorDetail> errorDetails = ex.getBindingResult().getAllErrors().stream().map(error ->
        new ErrorDetail(((FieldError) error).getField(), error.getDefaultMessage())
    ).toList();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ErrorResponse(ex.getBody().getTitle(), errorDetails));
  }
}
