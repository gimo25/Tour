package com.jalasoft.Tour.controller;

import com.jalasoft.Tour.dto.TestConfigDto;
import com.jalasoft.Tour.service.ConfigService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Giordano Bortolini
 */
@RestController
@RequestMapping("/config")
@AllArgsConstructor
public class ConfigController {

  @Autowired
  private final ConfigService service;

  @ResponseBody
  @GetMapping
  public TestConfigDto getUIConfiguration() {
    return service.getConfiguration();
  }
}
