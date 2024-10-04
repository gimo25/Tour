package com.jalasoft.Tour.controller;

import com.jalasoft.Tour.dto.TourPackageDTO;
import com.jalasoft.Tour.service.TourPackageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Giordano Bortolini
 */

@Tag(name = "Tours", description = "Tours API controller")
@RestController
@RequestMapping("/tour-package")
public class TourPackageController {

  @Autowired
  private TourPackageService service;

  @GetMapping("/{name}")
  @ResponseStatus(HttpStatus.OK)
  @Operation(summary = "Return Tour Package", description = "Get Tour Package by package name.")
  @ResponseBody
  @ApiResponse(responseCode = "200", content = {
      @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
      schema = @Schema(implementation = TourPackageDTO.class))
  })
  @ApiResponse(responseCode = "404", description = "Tour Package with name not found.",
      content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = String.class))
      })
  public TourPackageDTO getPackageByName(@PathVariable("name") String name) {
    return service.findByPackageName(name);
  }

  @GetMapping("/by-price")
  @ResponseBody
  public String getByLowerPrice() {
    return service.getLowerPricePackageDescription();
  }
}
