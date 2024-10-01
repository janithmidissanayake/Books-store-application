package com.janithmi.order_service.controller;

import com.janithmi.order_service.dto.OrderRequest;
import com.janithmi.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeNewOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeNewOrder(orderRequest);
        return "order placed successfully";

    }
}
