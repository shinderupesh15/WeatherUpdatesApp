package com.etraveli.weatherupdates.component;

import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserObserver implements Observer {
    private String name;
    private String location;
    private double temperatureCriteria;
    private List<String> notificationMethods;
    private boolean notified;

    private static final Logger LOGGER = LogManager.getLogger(UserObserver.class);
    public List<String> getNotificationMethods() {
        return notificationMethods;
    }

    @Override
    public void updateTemperature(String location, double temperature) {
        LOGGER.debug("Updating temperature for observer: {}", getName());
        if (!notified && temperature > temperatureCriteria && location.equalsIgnoreCase(this.location)) {
            NotificationService.sendNotification(this, location, temperature);
            notified = true;
        }
    }
}

