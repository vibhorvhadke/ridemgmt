package com.agenticai.ridemgmt.repository;

import com.agenticai.ridemgmt.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {
}
