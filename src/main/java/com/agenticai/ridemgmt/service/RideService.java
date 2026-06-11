package com.agenticai.ridemgmt.service;

import com.agenticai.ridemgmt.enums.RideStatus;
import com.agenticai.ridemgmt.model.Driver;
import com.agenticai.ridemgmt.model.FareReceipt;
import com.agenticai.ridemgmt.model.Ride;
import com.agenticai.ridemgmt.model.Rider;
import com.agenticai.ridemgmt.repository.DriverRepository;
import com.agenticai.ridemgmt.repository.RideRepository;
import com.agenticai.ridemgmt.repository.RiderRepository;
import com.agenticai.ridemgmt.strategy.DefaultFareStrategy;
import com.agenticai.ridemgmt.strategy.FareStrategy;
import com.agenticai.ridemgmt.strategy.NearestDriverStrategy;
import com.agenticai.ridemgmt.strategy.RideMatchingStrategy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RideService {
    private final DriverRepository driverRepository;
    private final RiderRepository riderRepository;
    private final RideRepository rideRepository;

    public RideService(DriverRepository driverRepository, RideRepository rideRepository, RiderRepository riderRepository) {
        this.driverRepository = driverRepository;
        this.rideRepository = rideRepository;
        this.riderRepository = riderRepository;
    }

    public Ride bookRide(Long riderId, double distance) {

        List<Driver> drivers = driverRepository.findByAvailable(true);
        Rider rider = riderRepository.findById(riderId).orElseThrow(() -> new RuntimeException("Rider not found"));

        RideMatchingStrategy matchingStrategy = new NearestDriverStrategy();
        Driver selectedDriver = matchingStrategy.findDriver(drivers, rider);

        FareStrategy fareStrategy = new DefaultFareStrategy();

        double fare = fareStrategy.calculateFare(distance);

        Ride ride = new Ride();
        ride.setRider(rider);
        ride.setDriver(selectedDriver);
        ride.setDistance(distance);
        ride.setStatus(RideStatus.ASSIGNED);

        selectedDriver.setAvailable(false);
        driverRepository.save(selectedDriver);

        FareReceipt receipt = new FareReceipt();
        receipt.setAmount(fare);
        receipt.setRide(ride);
        receipt.setGeneratedAt(LocalDateTime.now());

        ride.setFareReceipt(receipt);

        return rideRepository.save(ride);
    }
}
