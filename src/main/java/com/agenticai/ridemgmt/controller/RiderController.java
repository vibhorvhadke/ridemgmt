package com.agenticai.ridemgmt.controller;

import com.agenticai.ridemgmt.model.Rider;
import com.agenticai.ridemgmt.service.RiderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/riders")
public class RiderController {

    private final RiderService riderService;

    public RiderController(RiderService riderService) {
        this.riderService = riderService;
    }

    @PostMapping("/registerRide")
    ResponseEntity<Rider> registerRider(@RequestBody Rider ride) {
        Rider saveRider = riderService.registerRider(ride);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveRider);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rider> getRiderById(@PathVariable Long id) {

        Rider rider = riderService.getRiderById(id);

        return ResponseEntity.ok(rider);
    }
}