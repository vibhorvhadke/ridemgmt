package com.agenticai.ridemgmt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RideRequest {
    private Long riderId;
    private double distance;

    public RideRequest(Long riderId, double distance) {
        this.riderId = riderId;
        this.distance = distance;
    }

    public RideRequest() {
    }
}