package com.agenticai.ridemgmt.strategy;

public class DefaultFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distance) {
        return distance * 10;
    }
}
