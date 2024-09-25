package com.kadirsancar.rent_a_car_instern.dto;

import com.kadirsancar.rent_a_car_instern.model.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto  {
    private Long id;
    private String make;
    private String model;
    private double pricePerDay;
    private boolean isAvailable;
    // Diğer gerekli alanlar
}
