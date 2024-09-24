package com.jalasoft.Tour;

import com.jalasoft.Tour.service.AgentService;
import com.jalasoft.Tour.service.SpringBeansConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TourApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeansConfig.class);
		AgentService agent = context.getBean(AgentService.class);

		/*
		TourRepository repo = new TourRepository();
		AgentService agent = new AgentService(repo);

		new TourService(repo); //Creates tours in constructor*/

		// Do not invoke agent method before manager creates base tours
		System.out.println("\n******Explore Tour Catalogue******");
		agent.displayTours();

		System.out.println("\n******Explore Tours******");
		agent.displayToursBy(true);
		//SpringApplication.run(TourApplication.class, args);
	}

}
