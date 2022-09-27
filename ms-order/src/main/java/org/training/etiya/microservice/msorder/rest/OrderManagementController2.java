package org.training.etiya.microservice.msorder.rest;

import org.springframework.web.bind.annotation.*;
import org.training.etiya.microservice.msorder.rest.models.OrderResponse;
import org.training.etiya.microservice.msorder.rest.models.OrderRest;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderManagementController2 {

    @PutMapping
    public OrderResponse place(@RequestBody OrderRest orderRest) {
        return new OrderResponse().setOrderId(100L)
                                  .setDesc("Siparişiniz alındı 30 dk sonra gönderilecek");
    }

    @DeleteMapping
    public String cancel(@RequestParam("oid")  Long orderId){
        return "Siparişiniz iptal edildi";
    }


}
