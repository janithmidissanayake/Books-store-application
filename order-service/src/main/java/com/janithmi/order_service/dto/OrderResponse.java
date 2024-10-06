package com.janithmi.order_service.dto;

import com.janithmi.order_service.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class  OrderResponse {
    private Long orderId;
    private String orderNumber;
    private List<OrderLineItems> orderLineItemsList;
}
