package com.agenticai.ridemgmt.ai.tools;

import com.agenticai.ridemgmt.dto.RideRequest;
import com.agenticai.ridemgmt.model.Ride;
import com.agenticai.ridemgmt.service.RideService;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class RideTools {

    private final RideService rideService;

    public RideTools(RideService rideService) {
        this.rideService = rideService;
    }

    @Tool("Book a ride using riderId and distance")
    public Ride bookRide(Long riderId, double distance) {
        return rideService.bookRide(riderId, distance);
    }


    @Tool("Extract riderId and distance from text")
    public RideRequest extractRequest(String text) {
        return new RideRequest(2L, 150.0);
    }

}
