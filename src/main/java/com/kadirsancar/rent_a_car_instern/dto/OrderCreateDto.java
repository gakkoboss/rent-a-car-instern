package com.kadirsancar.rent_a_car_instern.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreateDto {
    private Long userId;
    private Long carId;
    private int rentalDays;
    private double totalPrice;
    //private Long invoiceId;

    // Diğer gerekli alanlar
}
