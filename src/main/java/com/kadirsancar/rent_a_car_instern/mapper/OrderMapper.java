package com.kadirsancar.rent_a_car_instern.mapper;

import com.kadirsancar.rent_a_car_instern.dto.OrderCreateDto;
import com.kadirsancar.rent_a_car_instern.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderCreateDto toDto(Order order) {
        if (order == null) {
            return null;
        }
        OrderCreateDto dto = new OrderCreateDto();

        if (order.getCar() != null) {
            dto.setCarId(order.getCar().getId());
        }
        dto.setRentalDays(order.getRentalDays());
        dto.setTotalPrice(order.getTotalPrice());

        //        if (order.getInvoice() != null) {
        //            dto.setInvoiceId(order.getInvoice().getId());
        //        }

        // Diğer gerekli alanları ayarla
        return dto;
    }

    public Order toEntity(OrderCreateDto dto) {
        if (dto == null) {
            return null;
        }
        Order order = new Order();

        // User ve Car nesnelerini ayarlamanız gerekebilir
        // order.setUser(userService.getUserById(dto.getUserId()).orElse(null));
        // order.setCar(carService.getCarById(dto.getCarId()).orElse(null));
        order.setRentalDays(dto.getRentalDays());
        order.setTotalPrice(dto.getTotalPrice());
        //order.setInvoice(invoiceService.getInvoiceById(dto.getInvoiceId()).orElse(null));
        // Diğer gerekli alanları ayarla
        return order;
    }
}
