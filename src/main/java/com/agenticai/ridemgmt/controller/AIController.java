package com.agenticai.ridemgmt.controller;

import com.agenticai.ridemgmt.ai.agent.RideAgent;
import com.agenticai.ridemgmt.model.Ride;
import com.agenticai.ridemgmt.service.RideService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/ai")
public class AIController {

    private final RideAgent rideAgent;

    public AIController(RideAgent rideAgent) {
        this.rideAgent = rideAgent;
    }

    @PostMapping("/ride")
    public String handleRequest(@RequestBody String input) {
        return rideAgent.process(input);
    }

//    private final RideService rideService;
//
//    public AIController(RideService rideService) {
//        this.rideService = rideService;
//    }
//
//
//    @PostMapping("/ride")
//    public String handleRequest(@RequestBody Map<String, String> request) {
//
//        String text = request.get("message");
//
//        // Simple parsing (POC)
//        Long riderId = 2L;
//        double distance = 6.0;
//
//        Ride ride = rideService.bookRide(riderId, distance);
//
//        return "Ride booked. Driver: " + ride.getDriver().getDrivername()
//                + ", Fare: " + ride.getFareReceipt().getAmount();
//    }

}