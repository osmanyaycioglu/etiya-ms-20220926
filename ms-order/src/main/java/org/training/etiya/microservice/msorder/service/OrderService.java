package org.training.etiya.microservice.msorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.etiya.microservice.customerapi.rest.models.CustomerRest;
import org.training.etiya.microservice.msorder.db.OrderDbOperations;
import org.training.etiya.microservice.msorder.integrations.customer.CustomerIntegration;
import org.training.etiya.microservice.msorder.integrations.restaurant.RestaurantIntegration;
import org.training.etiya.microservice.msorder.integrations.restaurant.models.PriceInfo;
import org.training.etiya.microservice.msorder.service.models.Order;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDbOperations orderDbOperations;

    @Autowired
    private RestaurantIntegration restaurantIntegration;

    @Autowired
    private CustomerIntegration customerIntegration;
    public Long placeOrder(Order order) {
        PriceInfo priceInfo = restaurantIntegration.calculateOrder(order);
        order.setTotalPrice(order.getTotalPrice());
        System.out.println(priceInfo.getDesc());
        Order orderDb = orderDbOperations.insertOrder(order);
        return orderDb.getOrderId();
    }

    public void cancelOrder(Long orderId) {
        orderDbOperations.removeOrder(orderId);
    }

    public Order getOneOrder(Long orderId) {
        return orderDbOperations.selectOne(orderId);
    }

    public List<Order> getAllPreparingOrders() {
        return orderDbOperations.getAllPreparingOrders();
    }

    public Long placeOrder2(Order order) {
        PriceInfo priceInfo = restaurantIntegration.calculateOrder2(order);
        order.setTotalPrice(order.getTotalPrice());
        System.out.println(priceInfo.getDesc());
        Order orderDb = orderDbOperations.insertOrder(order);
        return orderDb.getOrderId();

    }
    public Long placeOrder3(Order order) {
        CustomerRest customer = customerIntegration.getCustomerByNumber(order.getCustomerNumber());
        System.out.println(customer);
        PriceInfo priceInfo = restaurantIntegration.calculateOrder3(order);
        order.setTotalPrice(order.getTotalPrice());
        System.out.println(priceInfo.getDesc());
        Order orderDb = orderDbOperations.insertOrder(order);
        return orderDb.getOrderId();

    }

}
