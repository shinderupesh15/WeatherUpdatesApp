package com.etraveli.weatherupdates;

import com.etraveli.weatherupdates.component.NotificationService;
import com.etraveli.weatherupdates.component.WeatherSubject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class AppConfig {
    @Bean
    public WeatherSubject weatherSubject() {
        return new WeatherSubject(new ArrayList<>());
    }

    @Bean
    public NotificationService notificationService() {
        return new NotificationService();
    }
}
