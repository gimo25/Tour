package com.jalasoft.Tour.controller;

import com.jalasoft.Tour.dto.TourPackageDTO;
import com.jalasoft.Tour.service.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Giordano Bortolini
 */

@RestController
@RequestMapping("/tour-package")
public class TourPackageController {

  @Autowired
  private TourPackageService service;

  @GetMapping("/{name}")
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public TourPackageDTO getPackageByName(@PathVariable("name") String name) {
    return service.findByPackageName(name);
  }
}
