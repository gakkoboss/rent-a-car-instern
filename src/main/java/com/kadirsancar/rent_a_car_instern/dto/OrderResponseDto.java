package com.kadirsancar.rent_a_car_instern.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderResponseDto {
    private Long id;

    private Long userId;
    private String name;

    private Long carId;
    private String carName;

    private int rentalDays;
    private double totalPrice;

    private Long invoiceId;
    private double carPrice;
    private double totalAmount;

    // Diğer gerekli alanlar
}
