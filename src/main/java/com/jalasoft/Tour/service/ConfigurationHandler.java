package com.jalasoft.Tour.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jalasoft.Tour.dto.TestConfigDto;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Giordano Bortolini
 */
@Service
public class ConfigurationHandler {

  private static final String CONFIGURATION = "ui_test.json";

  public TestConfigDto readAllConfiguration() {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      Resource resource = new ClassPathResource(CONFIGURATION);
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      return objectMapper.readValue(resource.getInputStream(), TestConfigDto.class);
    }
    catch (IOException e) {
      throw new RuntimeException("Error reading configuration file.", e);
    }
  }

}
