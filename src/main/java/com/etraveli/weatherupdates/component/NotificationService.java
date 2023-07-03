package com.etraveli.weatherupdates.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class NotificationService {
    private static final Logger LOGGER = LogManager.getLogger(NotificationService.class);
    public static void sendNotification(UserObserver observer, String location, double temperature) {
        if (observer == null || observer.getNotificationMethods() == null) {
            throw new IllegalArgumentException("Invalid observer or notification methods");
        }

        List<String> notificationMethods = observer.getNotificationMethods();
        LOGGER.info("Sending notification to observer: {}", observer.getName());

        for (String method : notificationMethods) {
            switch (method) {
                case "Slack":
                    sendSlackNotification(location, temperature);
                    break;
                case "Email":
                    sendEmailNotification(location, temperature);
                    break;
                case "SMS":
                    sendSMSNotification(location, temperature);
                    break;
                // Handle other notification methods
            }
        }
    }

    private static void sendSlackNotification(String location, double temperature) {
        LOGGER.info("Notification sent on Slack");
        //TODO - Add logic here
    }

    private static void sendEmailNotification(String location, double temperature) {
        LOGGER.info("Notification sent on Email");
        //TODO - Add logic here
    }

    private static void sendSMSNotification(String location, double temperature) {
        LOGGER.info("Notification sent on SMS");
        //TODO - Add logic here
    }
}

