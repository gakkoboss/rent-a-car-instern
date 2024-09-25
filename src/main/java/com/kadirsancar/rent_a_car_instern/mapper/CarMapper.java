package com.kadirsancar.rent_a_car_instern.mapper;

import com.kadirsancar.rent_a_car_instern.dto.CarDto;
import com.kadirsancar.rent_a_car_instern.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDto toDto(Car car) {
        if (car == null) {
            return null;
        }
        CarDto dto = new CarDto();
        dto.setMake(car.getMake());
        dto.setModel(car.getModel());
        dto.setPricePerDay(car.getPricePerDay());
        dto.setAvailable(car.isAvailable());
        // Diğer gerekli alanları ayarla
        return dto;
    }

    public Car toEntity(CarDto dto) {
        if (dto == null) {
            return null;
        }
        Car car = new Car();
        car.setMake(dto.getMake());
        car.setModel(dto.getModel());
        car.setPricePerDay(dto.getPricePerDay());
        car.setAvailable(dto.isAvailable());
        // Diğer gerekli alanları ayarla
        return car;
    }

}
