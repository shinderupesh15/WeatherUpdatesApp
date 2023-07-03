package com.etraveli.weatherupdates.component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherSubject implements Subject {
    private static final Logger LOGGER = LogManager.getLogger(WeatherSubject.class);
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        LOGGER.debug("Registering Observer");
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        LOGGER.debug("Removing Observer");
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String location, double temperature) {
        for (Observer observer : observers) {
            observer.updateTemperature(location, temperature);
        }
    }

    public void updateTemperature(String location, double temperature) {
        LOGGER.debug("Updating temperature to: {} for location {}", temperature, location);
        notifyObservers(location, temperature);
    }
}

