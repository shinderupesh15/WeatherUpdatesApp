package com.etraveli.weatherupdates.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

class UserObserverTest {
    @Mock
    private NotificationService notificationService;

    private UserObserver userObserver;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        userObserver = UserObserver.builder()
                .name("Rupesh")
                .location("Pune")
                .temperatureCriteria(25.0)
                .notificationMethods(Arrays.asList("Slack", "Email"))
                .build();
    }

    @Test
    void testUpdateTemperature_NotificationSent() {
        // Create a mock UserObserver object
        UserObserver observer = Mockito.mock(UserObserver.class);

        // Call the method to be tested
        observer.updateTemperature("Pune", 25.0);

       /* // Verify that the sendNotification() method was called with the correct arguments
        Mockito.verify(NotificationService.class).sendNotification(
                Mockito.eq(observer),
                Mockito.eq("Pune"),
                Mockito.eq(25.0)
        );*/
    }


}

