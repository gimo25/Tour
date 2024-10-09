package com.jalasoft.Tour.application.validation;

import com.jalasoft.Tour.application.dto.TourDTO;
import com.jalasoft.Tour.domain.validation.AbstractDtoValidator;
import com.jalasoft.Tour.domain.validation.dto.ErrorDetail;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Giordano Bortolini
 */

public class TourDtoValidation extends AbstractDtoValidator<TourDTO> {

  @Override
  protected List<ErrorDetail> getAdditionalValidation(TourDTO tourDTO) {
    List<ErrorDetail> errors = new ArrayList<>();
    if (!tourDTO.getTitle().isEmpty() && tourDTO.getDescription().isEmpty()) {
      errors.add(
          new ErrorDetail("Tour DTO", "Description must be empty if title is not provided."));
    }
    return errors;
  }
}
