package com.kadirsancar.rent_a_car_instern.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private double carPrice; // Arabanın vergisiz fiyatı
    private double tax; // %5 vergi
    private double totalAmount; // Vergi dahil toplam tutar
}

