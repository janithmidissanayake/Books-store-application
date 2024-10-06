package com.janithmi.order_service.service;

import com.janithmi.order_service.dto.OrderLineItemDto;
import com.janithmi.order_service.dto.OrderRequest;
import com.janithmi.order_service.dto.OrderResponse;
import com.janithmi.order_service.model.Order;
import com.janithmi.order_service.model.OrderLineItems;
import com.janithmi.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;


    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        System.out.println("nnnn"+orders);
        return orders.stream().map(this::mapToOrderResponse).toList();
    }

    public void placeNewOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems =orderRequest.getOrderLineItemDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);

    }

    private OrderLineItems mapToDto(OrderLineItemDto orderLineItemDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setSkuCode(orderLineItemDto.getSkuCode());
        orderLineItems.setQuantity(orderLineItemDto.getQuantity());
        orderLineItems.setPrice(orderLineItemDto.getPrice());
        return orderLineItems;

    }
    private OrderLineItems mapToOrderLineItemsResponse(OrderLineItems orderLineItems) {
        // Since you're returning the same fields, no transformation is required
        return new OrderLineItems(
                orderLineItems.getId(),
                orderLineItems.getSkuCode(),
                orderLineItems.getQuantity(),
                orderLineItems.getPrice()
        );
    }
    private OrderResponse mapToOrderResponse(Order order) {
        List<OrderLineItems> orderLineItemsList = order.getOrderLineItemsList()
                .stream()
                .map(this::mapToOrderLineItemsResponse)  // Proper mapping of OrderLineItems
                .toList();
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(order.getOrderId());
        orderResponse.setOrderNumber(order.getOrderNumber());
        orderResponse.setOrderLineItemsList(orderLineItemsList);
        return orderResponse;
    }

}
