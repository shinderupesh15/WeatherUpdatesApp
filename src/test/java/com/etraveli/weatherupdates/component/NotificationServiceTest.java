package com.etraveli.weatherupdates.component;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.when;

class NotificationServiceTest {
    @Test
    void testSendNotification_SlackMethodCalled() {
        UserObserver observer = Mockito.mock(UserObserver.class);
        when(observer.getNotificationMethods()).thenReturn(Arrays.asList("Slack")); 

        String location = "Pune";
        double temperature = 25.0;
        NotificationService.sendNotification(observer, location, temperature);
    }

    @Test
    void testSendNotification_ApplicationMethodCalled() {
        UserObserver observer = Mockito.mock(UserObserver.class);
        when(observer.getNotificationMethods()).thenReturn(Arrays.asList("Email")); 

        String location = "Pune";
        double temperature = 25.0;
        NotificationService.sendNotification(observer, location, temperature);
    }

    @Test
    void testSendNotification_SMSMethodCalled() {
        UserObserver observer = Mockito.mock(UserObserver.class);
        when(observer.getNotificationMethods()).thenReturn(Arrays.asList("SMS")); 

        String location = "Pune";
        double temperature = 25.0;
        NotificationService.sendNotification(observer, location, temperature);
    }
}

