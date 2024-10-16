package com.jalasoft.Tour.application.controller;

import com.jalasoft.Tour.application.dto.ClientRatingDto;
import com.jalasoft.Tour.application.dto.RatingDto;
import com.jalasoft.Tour.service.TourRatingService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Giordano Bortolini
 */
@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingController {

  @Autowired
  private TourRatingService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public RatingDto createTourRating(@PathVariable(value = "tourId") UUID tourId, @RequestBody RatingDto ratingDto) {
    return service.createTourRating(tourId, ratingDto);
  }

  @GetMapping("/all/client/{ratingId}")
  public List<ClientRatingDto> getAllClientsByRatingId(@PathVariable(value = "ratingId") String ratingId) {

    return service.getClientsByRatingId(ratingId);
  }

  @GetMapping("/all/client/async/{ratingId}")
  public Flux<ClientRatingDto> getAllClientsByRatingIdAsync(@PathVariable(value = "ratingId") String ratingId) {
    return service.getClientsByRatingIdAsync(ratingId);
  }
}
