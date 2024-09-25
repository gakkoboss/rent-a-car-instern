package com.kadirsancar.rent_a_car_instern.service;

import com.kadirsancar.rent_a_car_instern.dto.CarDto;
import com.kadirsancar.rent_a_car_instern.dto.OrderCreateDto;
import com.kadirsancar.rent_a_car_instern.mapper.OrderMapper;
import com.kadirsancar.rent_a_car_instern.model.Car;
import com.kadirsancar.rent_a_car_instern.model.Invoice;
import com.kadirsancar.rent_a_car_instern.model.Order;
import com.kadirsancar.rent_a_car_instern.model.User;
import com.kadirsancar.rent_a_car_instern.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.kadirsancar.rent_a_car_instern.mapper.CarMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final InvoiceService invoiceService;
    private CarDto carDto;

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    private CarMapper carMapper;

    private final CarService carService;

    private final UserService userService;


    public List<OrderCreateDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<OrderCreateDto> getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(orderMapper::toDto);
    }

    public Order saveOrder(OrderCreateDto orderCreateDto) {
        User user = userService.getUserById(orderCreateDto.getUserId());

        Car car = carService.getCarById(orderCreateDto.getCarId());




        //Order order = orderMapper.toEntity(orderDto);
        Order order = Order.builder()
                .user(user)
                .car(car)
//                .invoice()
                .rentalDays(orderCreateDto.getRentalDays())
                .totalPrice(orderCreateDto.getTotalPrice())
                .build();

        Order savedOrder = orderRepository.save(order);

        double calculatedTotalAmount = calculateTotalAmount(orderCreateDto.getTotalPrice());
        Invoice invoiceToSave = Invoice.builder()
                .order(savedOrder)
                .carPrice(car.getPricePerDay())
                .tax(5)
                .totalAmount(calculatedTotalAmount)
                .build();

        Invoice savedInvoice = invoiceService.saveInvoice(invoiceToSave);

        //return orderMapper.toDto(savedOrder);
        return savedOrder;
    }

    private double calculateTotalAmount(double totalPrice) {
        return totalPrice * 0.05;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

