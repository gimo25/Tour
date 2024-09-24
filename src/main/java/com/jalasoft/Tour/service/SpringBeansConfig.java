package com.jalasoft.Tour.service;

import com.jalasoft.Tour.repository.TourRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Giordano Bortolini
 */
@Configuration
public class SpringBeansConfig {
  @Bean
  public TourRepository tourRepository() {
    return new TourRepository();
  }

  @Bean
  public TourService tourService() {
    return new TourService(tourRepository());
  }

  @Bean
  public AgentService agentService() {
    return new AgentService(tourRepository());
  }

}
