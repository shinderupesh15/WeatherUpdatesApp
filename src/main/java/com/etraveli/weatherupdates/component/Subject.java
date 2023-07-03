package com.etraveli.weatherupdates.component;

public interface Subject {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers(String location, double temperature);
}

