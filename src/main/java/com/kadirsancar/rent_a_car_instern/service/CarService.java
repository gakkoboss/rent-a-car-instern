package com.kadirsancar.rent_a_car_instern.service;

import com.kadirsancar.rent_a_car_instern.dto.CarDto;
import com.kadirsancar.rent_a_car_instern.mapper.CarMapper;
import com.kadirsancar.rent_a_car_instern.model.Car;
import com.kadirsancar.rent_a_car_instern.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarMapper carMapper;

    public List<CarDto> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(carMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<CarDto> getOptionalCarById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car.map(carMapper::toDto);
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found by Id: " + id));
    }

    public CarDto saveCar(CarDto carDto) {
        Car car = carMapper.toEntity(carDto);
        Car savedCar = carRepository.save(car);
        return carMapper.toDto(savedCar);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
