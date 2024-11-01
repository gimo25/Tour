package com.jalasoft.Tour.application.controller;

import com.jalasoft.Tour.application.dto.TourViewDto;
import com.jalasoft.Tour.service.TourViewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Giordano Bortolini
 */
@Tag(name = "Tours", description = "Tours Images controller")
@RestController
@RequestMapping("/tour/images")
public class TourViewController {

  @Autowired
  private TourViewService service;

  @PostMapping(value = "upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> handleUpload(@RequestParam("file") MultipartFile file) throws IOException {
    TourViewDto image = service.saveImage(file);
    return ResponseEntity.ok(image.getId());
  }

  @GetMapping("/{id}")
  public ResponseEntity<byte[]> handleDownload(@PathVariable String id)
      throws FileNotFoundException {
    TourViewDto image = service.getTourImage(id);
    return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
        STR."attachment; filename=\"\{image.getFileName()}\"")
        .body(image.getData());
  }

}
