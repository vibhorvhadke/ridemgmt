package com.agenticai.ridemgmt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class FareReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private Double amount;

    private LocalDateTime generatedAt;

    @OneToOne
    @JoinColumn(name = "ride_id")
    @JsonIgnore
    private Ride ride;
}
