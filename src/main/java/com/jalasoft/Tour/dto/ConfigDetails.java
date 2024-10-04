package com.jalasoft.Tour.dto;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Giordano Bortolini
 */
@Getter
@Setter
public class ConfigDetails {

  private String displayName;
  private Map<String, ConfigSection> sections;

}
