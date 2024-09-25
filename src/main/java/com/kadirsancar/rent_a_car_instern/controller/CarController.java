package com.kadirsancar.rent_a_car_instern.controller;

import com.kadirsancar.rent_a_car_instern.dto.CarDto;
import com.kadirsancar.rent_a_car_instern.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cars")
public class CarController {


    private final CarService carService;

    @GetMapping
    public List<CarDto> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long id) {
        Optional<CarDto> carDto = carService.getOptionalCarById(id);
        return carDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CarDto createCar(@RequestBody CarDto carDto) {
        return carService.saveCar(carDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable Long id, @RequestBody CarDto carDto) {
        if (!carService.getOptionalCarById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        carDto.setId(id);
        return ResponseEntity.ok(carService.saveCar(carDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        if (!carService.getOptionalCarById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
