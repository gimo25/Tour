package com.jalasoft.Tour.dto;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Giordano Bortolini
 */
@Getter
@Setter
public class ConfigSection {

  private Boolean isAuthorized;

  private String displayName;
  private List<Map<String, SectionItem>> fields;
}
