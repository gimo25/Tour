package com.jalasoft.Tour.configuration.service;

import com.jalasoft.Tour.configuration.dto.ConfigDto;
import com.jalasoft.Tour.configuration.handler.ConfigurationHandler;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Giordano Bortolini
 */
@Getter
@Service
public class ConfigService {

  private final ConfigDto configuration;

  @Autowired
  public ConfigService(ConfigurationHandler handler) {
    this.configuration = handler.readAllConfiguration();
  }
}
