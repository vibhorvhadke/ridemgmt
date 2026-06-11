package com.agenticai.ridemgmt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long riderId;

    private String name;

    @OneToMany(mappedBy = "rider", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ride> rides;

    public Rider() {
    }
}
