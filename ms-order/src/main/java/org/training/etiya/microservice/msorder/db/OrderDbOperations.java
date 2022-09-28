package org.training.etiya.microservice.msorder.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.etiya.microservice.msorder.db.dao.IOrderDao;
import org.training.etiya.microservice.msorder.service.models.EOrderStatus;
import org.training.etiya.microservice.msorder.service.models.Order;

import java.util.List;

@Service
public class OrderDbOperations {

    @Autowired
    private IOrderDao orderDao;

    public Order insertOrder(Order order){
        return orderDao.save(order);
    }

    public void removeOrder(Long orderId) {
        orderDao.deleteById(orderId);
    }

    public Order selectOne(Long orderId) {
        return orderDao.findById(orderId).orElse(null);
    }

    public List<Order> getAllPreparingOrders() {
        return orderDao.findByOrderStatus(EOrderStatus.PREPARING);
    }
}
