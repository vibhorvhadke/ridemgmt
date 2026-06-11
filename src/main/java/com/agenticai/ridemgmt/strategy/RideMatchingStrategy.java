package com.agenticai.ridemgmt.strategy;

import com.agenticai.ridemgmt.model.Driver;
import com.agenticai.ridemgmt.model.Rider;

import java.util.List;

public interface RideMatchingStrategy {
    Driver findDriver(List<Driver> drivers, Rider rider);
}

