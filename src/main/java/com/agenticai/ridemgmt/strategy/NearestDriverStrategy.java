package com.agenticai.ridemgmt.strategy;

import com.agenticai.ridemgmt.model.Driver;
import com.agenticai.ridemgmt.model.Rider;

import java.util.List;

public class NearestDriverStrategy implements RideMatchingStrategy {
    @Override
    public Driver findDriver(List<Driver> drivers, Rider rider) {
        return drivers.get(0);
    }
}
