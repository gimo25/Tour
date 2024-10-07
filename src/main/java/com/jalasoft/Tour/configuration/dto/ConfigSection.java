package com.jalasoft.Tour.configuration.dto;

import com.jalasoft.Tour.application.dto.SectionItem;
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

  private String displayName;
  private List<Map<String, SectionItem>> fields;
}
