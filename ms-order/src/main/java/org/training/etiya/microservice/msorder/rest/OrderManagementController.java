package org.training.etiya.microservice.msorder.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.training.etiya.microservice.msorder.rest.models.OrderResponse;
import org.training.etiya.microservice.msorder.rest.models.OrderRest;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderManagementController {

    @PostMapping("/place")
    @Operation(summary = "Sipariş vermek için kulllanılır.", tags = "order-management", description = "Müşteri bilgisiyle başka bir sistemden sipariş verme")
    public OrderResponse place(@RequestBody OrderRest orderRest) {
        return new OrderResponse().setOrderId(100L)
                                  .setDesc("Siparişiniz alındı 30 dk sonra gönderilecek");
    }

    @GetMapping("/cancel")
    public String cancel(@RequestParam("oid") Long orderId) {
        return "Siparişiniz iptal edildi";
    }


}
