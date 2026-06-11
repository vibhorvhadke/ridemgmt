package com.agenticai.ridemgmt.repository;

import com.agenticai.ridemgmt.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider, Long> {
}
