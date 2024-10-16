package com.jalasoft.Tour.service;

import com.jalasoft.Tour.application.dto.ClientRatingDto;
import com.jalasoft.Tour.application.dto.RatingDto;
import com.jalasoft.Tour.infrastructure.aggregate.TourAggregate;
import com.jalasoft.Tour.infrastructure.aggregate.TourRatingAggregate;
import com.jalasoft.Tour.infrastructure.persistence.repository.TourRatingRepository;
import com.jalasoft.Tour.infrastructure.persistence.repository.TourRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

/**
 * @author Giordano Bortolini
 */
@Service
@Slf4j
public class TourRatingService {

  @Autowired
  private TourRatingRepository ratingRepository;
  @Autowired
  private TourRepository tourRepository;

  public RatingDto createTourRating(UUID tourId, RatingDto ratingDto) {
    TourAggregate tourEntity = tourRepository.findById(tourId).orElseThrow(() -> new RuntimeException("Tour id not found."));
    ratingDto.setTourId(tourId);
    ratingDto.setTour(tourEntity.toDTO());
    TourRatingAggregate tourRatingEntity = new TourRatingAggregate(ratingDto);
    ratingRepository.save(tourRatingEntity);

    return tourRatingEntity.toDTO();
  }

  /**
   * this is a sync method.
   * @param ratingId
   * @return
   */
  public List<ClientRatingDto> getClientsByRatingId(String ratingId) {
    log.info("Start calling external service");
    Optional<TourRatingAggregate> ratingAggregate = ratingRepository.findById(
        UUID.fromString(ratingId));
    List<ClientRatingDto> clients = new ArrayList<>();
    if (ratingAggregate.isPresent()) {
      RestTemplate restTemplate = new RestTemplate();
      ResponseEntity<List<ClientRatingDto>> response = restTemplate.exchange(
          "http://localhost:8081/client/all", HttpMethod.GET, null,
          new ParameterizedTypeReference<List<ClientRatingDto>>() {
          });

      clients = response.getBody();

      if (clients != null) {
        clients.forEach(client -> {
          log.info("client info: {}", client);
          client.setRating(ratingAggregate.get().toDTO());
        });
      }
    }
    log.info("End Calling External service");
    return clients;
  }

  public Flux<ClientRatingDto> getClientsByRatingIdAsync(String ratingId) {
    log.info("Start calling external service");
    Optional<TourRatingAggregate> ratingAggregate = ratingRepository.findById(
        UUID.fromString(ratingId));
    Flux<ClientRatingDto> response = null;
    if (ratingAggregate.isPresent()) {
      WebClient webClient = WebClient.create();
      response = webClient.get()
          .uri("http://localhost:8081/client/all").retrieve().bodyToFlux(ClientRatingDto.class);

      response.subscribe(client -> {
        log.info("client info: {}", client);
        client.setRating(ratingAggregate.get().toDTO());
      });

    }
    log.info("End Calling External service");
    return response;
  }
}
