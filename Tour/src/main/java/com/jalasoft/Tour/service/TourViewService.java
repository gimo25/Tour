package com.jalasoft.Tour.service;

import com.jalasoft.Tour.application.dto.TourViewDto;
import com.jalasoft.Tour.domain.entity.TourImage;
import com.jalasoft.Tour.infrastructure.aggregate.TourViewAggregate;
import com.jalasoft.Tour.infrastructure.persistence.repository.TourViewRepository;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Giordano Bortolini
 */
@Service
public class TourViewService {

  private TourViewRepository repository;

  @Autowired
  public TourViewService(TourViewRepository repository) {
    this.repository = repository;
  }

  public TourViewDto saveImage(MultipartFile file) throws IOException {
    TourImage tourImage = TourImage.builder().fileName(file.getOriginalFilename())
        .data(file.getBytes()).build();

    return repository.save(TourViewAggregate.fromDomain(tourImage)).toDTO();
  }

  public TourViewDto getTourImage(String id) throws FileNotFoundException {
    TourViewAggregate tourImage = repository.findById(id).orElseThrow(FileNotFoundException::new);

    return tourImage.toDTO();
  }
}
