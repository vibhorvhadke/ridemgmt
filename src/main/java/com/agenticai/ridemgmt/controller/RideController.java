package com.agenticai.ridemgmt.controller;

import com.agenticai.ridemgmt.dto.RideRequest;
import com.agenticai.ridemgmt.model.Ride;
import com.agenticai.ridemgmt.service.RideService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @PostMapping
    public ResponseEntity<Ride> bookRide(@RequestBody RideRequest request) {
        Ride ride = rideService.bookRide(request.getRiderId(), request.getDistance());
        return ResponseEntity.status(HttpStatus.CREATED).body(ride);
    }
}


