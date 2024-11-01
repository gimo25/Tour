package com.jalasoft.Tour.domain.validation;

import com.jalasoft.Tour.domain.validation.dto.ErrorDetail;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.http.HttpStatus;

/**
 * @author Giordano Bortolini
 */
public abstract class AbstractDtoValidator<DTO> {

  public void validate(final DTO dto) {
    List<ErrorDetail> errors = new ArrayList<>();
    errors.addAll(getTagValidation(dto));
    errors.addAll(getAdditionalValidation(dto));

    if (!errors.isEmpty()) {
      throw new BadRequestDTOException("dto.name", errors, HttpStatus.BAD_REQUEST);
    }
  }

  private List<ErrorDetail> getTagValidation(DTO dto) {
    try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
      Set<ConstraintViolation<DTO>> validations = validatorFactory.getValidator().validate(dto);

      return validations.stream().map(violation ->
        new ErrorDetail(violation.getPropertyPath().toString(),
            STR."dto.name:\{violation.getMessage()}")
      ).toList();

    }
  }

  protected abstract List<ErrorDetail> getAdditionalValidation(DTO dto);

}
