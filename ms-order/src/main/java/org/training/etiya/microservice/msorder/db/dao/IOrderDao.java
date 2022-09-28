package org.training.etiya.microservice.msorder.db.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.training.etiya.microservice.msorder.service.models.EOrderStatus;
import org.training.etiya.microservice.msorder.service.models.Order;

import java.util.List;

public interface IOrderDao extends CrudRepository<Order, Long> {

    List<Order> findByOrderStatus(EOrderStatus orderStatus);

    List<Order> findByOrderStatusAndCustomerNumberOrderByCustomerName(EOrderStatus orderStatus,
                                                                      String customerNumber);

    List<Order> findByCustomerNumber(String customerNumber);

    @Query("select o from Order o where o.customerNumber=?1")
    List<Order> searchOrder(String customerNumber);

    @Query(value = "select * from istek o where o.customer_number=?1",nativeQuery = true)
    List<Order> searchOrderNative(String customerNumber);

}
