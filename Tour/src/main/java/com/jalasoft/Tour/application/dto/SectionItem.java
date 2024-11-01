package com.jalasoft.Tour.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Giordano Bortolini
 */
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class SectionItem {

  private String label;
  private String type;
  private String state;
  private List<String> values;
  private String defaultValue;

}
