package com.jalasoft.Tour.configuration.handler;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jalasoft.Tour.configuration.dto.ConfigDto;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Giordano Bortolini
 */
@Service
public class ConfigurationHandler {

  private static final String CONFIGURATION = "ui_config.json";

  public ConfigDto readAllConfiguration() {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      Resource resource = new ClassPathResource(CONFIGURATION);
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      return objectMapper.readValue(resource.getInputStream(), ConfigDto.class);
    }
    catch (IOException e) {
      throw new RuntimeException("Error reading configuration file.", e);
    }
  }

}
