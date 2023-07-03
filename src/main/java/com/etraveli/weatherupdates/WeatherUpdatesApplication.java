package com.etraveli.weatherupdates;

import com.etraveli.weatherupdates.component.NotificationService;
import com.etraveli.weatherupdates.component.UserObserver;
import com.etraveli.weatherupdates.component.WeatherSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class WeatherUpdatesApplication implements CommandLineRunner {
	@Autowired
	private WeatherSubject weatherSubject;

	@Autowired
	private NotificationService notificationService;

	public static void main(String[] args) {
		SpringApplication.run(WeatherUpdatesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create user observers
		UserObserver userObserver1 = UserObserver.builder()
				.name("Rupesh")
				.location("Pune")
				.temperatureCriteria(25.0)
				.notificationMethods(Arrays.asList("Slack", "Email"))
				.build();

		UserObserver userObserver2 = UserObserver.builder()
				.name("John")
				.location("London")
				.temperatureCriteria(22.0)
				.notificationMethods(Arrays.asList("SMS", "Email"))
				.build();


		// Register user observers with the weather subject
		weatherSubject.registerObserver(userObserver1);
		weatherSubject.registerObserver(userObserver2);

		// Simulate temperature updates and trigger notifications
		weatherSubject.updateTemperature("Pune", 28.0);
		weatherSubject.updateTemperature("Mumbai", 30.0);
		weatherSubject.updateTemperature("London", 25.0);
		weatherSubject.updateTemperature("Pune", 20.0);
	}
}
