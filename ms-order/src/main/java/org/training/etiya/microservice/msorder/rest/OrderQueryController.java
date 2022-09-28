package org.training.etiya.microservice.msorder.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.training.etiya.microservice.msorder.rest.mappings.IOrderMapping;
import org.training.etiya.microservice.msorder.rest.models.OrderRest;
import org.training.etiya.microservice.msorder.service.OrderService;
import org.training.etiya.microservice.msorder.service.models.Order;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order/query")
public class OrderQueryController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/get/one")
    public OrderRest getOneOrder(@RequestParam("oid") Long orderId) {
        return IOrderMapping.ordermapper.toOrderRest(orderService.getOneOrder(orderId));
    }

    @GetMapping("/get/preparing")
    public List<OrderRest> getAllPreparingOrders() {
        return IOrderMapping.ordermapper.toOrderRestList(orderService.getAllPreparingOrders());
    }


}
