package com.jalasoft.Tour.controller;

import com.jalasoft.Tour.dto.TourDTO;
import com.jalasoft.Tour.record.pattern.AdultTicket;
import com.jalasoft.Tour.record.pattern.Ticket;
import com.jalasoft.Tour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Giordano Bortolini
 */
@RestController
@RequestMapping("/tour")
public class TourController {

  @Autowired
  private TourService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TourDTO createTour(@RequestBody final TourDTO tour) {
    return service.createTour(tour);
  }

  @GetMapping("/ticket")
  @ResponseStatus(HttpStatus.OK)
  public String getTicket() {
    Ticket ticket = new AdultTicket(1,"Adult Ticket");
    return service.ticketMessage(ticket);
  }
}
