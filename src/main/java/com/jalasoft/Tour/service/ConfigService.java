package com.jalasoft.Tour.service;

import com.jalasoft.Tour.dto.TestConfigDto;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Giordano Bortolini
 */
@Getter
@Service
public class ConfigService {

  private final TestConfigDto configuration;

  @Autowired
  public ConfigService(ConfigurationHandler handler) {
    this.configuration = handler.readAllConfiguration();
  }
}
