package com.etraveli.weatherupdates.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class WeatherSubjectTest {
    @Mock
    private Observer observer;

    private WeatherSubject weatherSubject;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        weatherSubject = new WeatherSubject();
    }

    @Test
    void testUpdateTemperature_NotifyObservers() {
        double temperature = 25.0;
        weatherSubject.registerObserver(observer);
        weatherSubject.updateTemperature("Pune", temperature);
        verify(observer, times(1)).updateTemperature("Pune", temperature);
    }

    @Test
    void testUpdateTemperature_NoObservers() {
        double temperature = 25.0;
        weatherSubject.updateTemperature("Pune", temperature);
        verify(observer, never()).updateTemperature(anyString(), anyDouble());
    }
}

