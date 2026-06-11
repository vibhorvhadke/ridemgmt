package com.agenticai.ridemgmt.model;

import com.agenticai.ridemgmt.enums.RideStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity

@Getter
@Setter

public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double distance;
    @Enumerated(EnumType.STRING)
    private RideStatus status;
    @ManyToOne
    @JoinColumn(name = "rider_id")
    private Rider rider;
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @OneToOne(mappedBy = "ride", cascade = CascadeType.ALL)
    private FareReceipt fareReceipt;

    public Ride() {
    }
}
