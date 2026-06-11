package com.agenticai.ridemgmt.service;

import com.agenticai.ridemgmt.model.Rider;
import com.agenticai.ridemgmt.repository.RiderRepository;
import org.springframework.stereotype.Service;

@Service

public class RiderService {

    private final RiderRepository riderRepository;

    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    public Rider registerRider(Rider rider) {
        return riderRepository.save(rider);
    }

    public Rider getRiderById(Long id) {
        return riderRepository.findById(id).orElseThrow(() -> new RuntimeException("Rider Not Found"));
    }
}

