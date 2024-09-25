package com.kadirsancar.rent_a_car_instern.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceDto {
    private Long orderId;
    private long carId;
    private double dailyPrice;
    private int rentalDays;
    private double totalPrice;
    private double taxAmount;
    private double totalAmount;

    // Diğer gerekli alanlar
}
