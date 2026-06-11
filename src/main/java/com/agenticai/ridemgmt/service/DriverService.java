package com.agenticai.ridemgmt.service;

import com.agenticai.ridemgmt.model.Driver;
import com.agenticai.ridemgmt.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver registerDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> getDrivers(Boolean available) {

        return driverRepository.findByAvailable(true);
    }

    public Driver updateAvailabilityStatus(Long driverId, Boolean available) {

        Driver driver = driverRepository.findById(driverId).orElseThrow(() -> new RuntimeException("Driver Not Found"));
        driver.setAvailable(available);
        return driverRepository.save(driver);
    }
}
