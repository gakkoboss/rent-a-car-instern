package com.kadirsancar.rent_a_car_instern.controller;

import com.kadirsancar.rent_a_car_instern.dto.OrderCreateDto;
import com.kadirsancar.rent_a_car_instern.dto.OrderResponseDto;
import com.kadirsancar.rent_a_car_instern.model.Order;
import com.kadirsancar.rent_a_car_instern.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderCreateDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderCreateDto> getOrderById(@PathVariable Long id) {
        Optional<OrderCreateDto> orderDto = orderService.getOrderById(id);
        return orderDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderResponseDto createOrder(@RequestBody OrderCreateDto orderCreateDto) {
        Order order = orderService.saveOrder(orderCreateDto);
        return new OrderResponseDto(
                order.getId(), // orderId
                order.getUser().getId(),
                null,
                null,
                null,
                0,
                0,
                null,
                0,
                0
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderCreateDto> updateOrder(@PathVariable Long id, @RequestBody OrderCreateDto orderCreateDto) {
        if (!orderService.getOrderById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        //return ResponseEntity.ok(orderService.saveOrder(orderCreateDto));
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (!orderService.getOrderById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
