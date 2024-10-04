package com.jalasoft.Tour.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Giordano Bortolini
 */
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class TestConfigDto {

  private String displayName;
  private Map<String, ConfigDetails> config;


}
