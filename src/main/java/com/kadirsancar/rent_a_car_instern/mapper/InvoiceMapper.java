package com.kadirsancar.rent_a_car_instern.mapper;

import com.kadirsancar.rent_a_car_instern.dto.InvoiceDto;
import com.kadirsancar.rent_a_car_instern.model.Invoice;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {

    private static final double TAX_RATE = 0.05;

    public InvoiceDto toDto(Invoice invoice) {
        InvoiceDto invoiceDto = new InvoiceDto();


        // Order ID ve Car ID'yi set et
        invoiceDto.setOrderId(invoice.getOrder().getId());
        invoiceDto.setCarId(invoice.getOrder().getCar().getId()); // Siparişle ilişkili araba ID'si

        // Kiralama gün sayısını al
        int rentalDays = invoice.getOrder().getRentalDays();

        // Toplam fiyatı hesapla
        double dailyPrice = invoice.getCarPrice(); // Günlük fiyat
        double totalPrice = dailyPrice * rentalDays; // Toplam fiyat


        // Fiyatları set et
        invoiceDto.setTotalPrice(totalPrice);

        // Vergiyi, toplam fiyatın %5'i olarak hesapla
        double taxAmount = totalPrice * TAX_RATE;
        invoiceDto.setTaxAmount(taxAmount);

        // Toplam tutarı hesapla (vergi dahil)
        double totalAmount = totalPrice + taxAmount;
        invoiceDto.setTotalAmount(totalAmount);

        // Kiralama gün sayısını set et
        invoiceDto.setRentalDays(rentalDays);
        invoiceDto.setDailyPrice(dailyPrice);

        return invoiceDto;
    }

    public Invoice toEntity(InvoiceDto invoiceDto) {
        Invoice invoice = new Invoice();

        // Günlük fiyatı geri hesapla
        double dailyPrice = invoiceDto.getTotalPrice() / invoiceDto.getRentalDays();
        invoice.setCarPrice(dailyPrice);
        invoice.setTax(invoiceDto.getTaxAmount());
        invoice.setTotalAmount(invoiceDto.getTotalAmount());

        // Order burada set edilmesi gerek (örneğin: invoice.setOrder(orderRepository.findById(invoiceDto.getOrderId()).orElse(null)));

        return invoice;
    }
}
