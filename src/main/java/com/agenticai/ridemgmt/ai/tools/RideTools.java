package com.agenticai.ridemgmt.ai.tools;

import com.agenticai.ridemgmt.dto.RideRequest;
import com.agenticai.ridemgmt.model.Ride;
import com.agenticai.ridemgmt.service.RideService;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;
import dev.langchain4j.agent.tool.P;

@Component
public class RideTools {

    private final RideService rideService;

    public RideTools(RideService rideService) {
        this.rideService = rideService;
    }

    @Tool("Book a ride for a rider for the given distance")
    public String bookRide(@P("rider id") Long riderId,
                           @P("distance in km") double distance) {
        System.out.println("AI called bookRide: riderId=" + riderId + ", distance=" + distance);
        try {
            Ride ride = rideService.bookRide(riderId, distance);
            return "Ride booked. Ride ID: " + ride.getId()
                    + ", Driver: " + ride.getDriver().getDrivername()
                    + ", Fare: " + ride.getFareReceipt().getAmount()
                    + ", Status: " + ride.getStatus();
        } catch (Exception e) {
            return "Booking failed: " + e.getMessage();
        }
    }


//    @Tool("Extract riderId and distance from text")
//    public RideRequest extractRequest(String text) {
//        return new RideRequest(2L, 150.0);
//    }

}
