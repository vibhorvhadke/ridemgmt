package com.agenticai.ridemgmt.strategy;

public class PeakHourFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distance) {
        return distance * 15;
    }
}
