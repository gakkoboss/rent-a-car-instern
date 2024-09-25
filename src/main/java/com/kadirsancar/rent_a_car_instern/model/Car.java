package com.kadirsancar.rent_a_car_instern.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make; // Marka
    private String model;
    private double pricePerDay; // Günlük kiralama ücreti

    private boolean isAvailable;

    @OneToMany(mappedBy = "car")
    private Set<Order> orders;

    // Diğer özellikler: renk, yıl vs. eklenebilir
}
