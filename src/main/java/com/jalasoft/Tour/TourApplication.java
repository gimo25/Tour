package com.jalasoft.Tour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TourApplication {

	public static void main(String[] args) {
		/*ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeansConfig.class);
		AgentService agent = context.getBean(AgentService.class);
		TourService tour = context.getBean(TourService.class);
		tour.createTour("Colombia", 750, true);
		tour.createTour("Day Spa Package", 200, false);
		tour.createTour("Monterey to Santa Barbara Tour", 550, false);
		tour.createTour("Kids L.A. Tour", 100, true);
		tour.createTour("Islands of the Blue Dolphins Tour", 200, true);
		tour.createTour("Endangered Species Expedition", 250, true);
		// Do not invoke agent method before manager creates base tours
		System.out.println("\n******Explore Tour Catalogue******");
		agent.displayTours();

		System.out.println("\n******Explore Tours******");
		agent.displayToursBy(true);*/
		SpringApplication.run(TourApplication.class, args);
	}

}
