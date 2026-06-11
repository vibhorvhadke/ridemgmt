package com.agenticai.ridemgmt.controller;

import com.agenticai.ridemgmt.model.Driver;
import com.agenticai.ridemgmt.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public ResponseEntity<Driver> registerDriver(@RequestBody Driver driver) {
        Driver saveDriver = driverService.registerDriver(driver);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveDriver);
    }

    @GetMapping
    public ResponseEntity<List<Driver>> getDrivers(@RequestParam(value = "available", required = false) Boolean available) {

        List<Driver> drivers = driverService.getDrivers(available);

        return ResponseEntity.ok(drivers);
    }

    @PatchMapping
    public ResponseEntity<Driver> updateAvailability(@RequestParam(value = "driverId", required = true) Long driverId, @RequestParam(value = "available", required = false) Boolean available) {
        Driver driver = driverService.updateAvailabilityStatus(driverId, available);
        return ResponseEntity.ok(driver);
    }
}
