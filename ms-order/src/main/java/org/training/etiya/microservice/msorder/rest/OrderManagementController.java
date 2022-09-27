package org.training.etiya.microservice.msorder.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.training.etiya.microservice.msorder.rest.models.OrderResponse;
import org.training.etiya.microservice.msorder.rest.models.OrderRest;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api/v1/order/management")
@Valid
public class OrderManagementController {

    @PostMapping("/place")
    @Operation(summary = "Sipariş vermek için kulllanılır.", tags = "order-management", description = "Müşteri bilgisiyle başka bir sistemden sipariş verme")
    public OrderResponse place(@Valid @RequestBody OrderRest orderRest) {
        if (orderRest.getCustomerName() == null){
            throw new IllegalArgumentException("Müşteri ismi boş olamaz");
        }
        return new OrderResponse().setOrderId(100L)
                                  .setDesc("Siparişiniz alındı 30 dk sonra gönderilecek");
    }

    @GetMapping("/cancel")
    public String cancel(@Positive @Min(10) @RequestParam("oid") Long orderId) {
        return "Siparişiniz iptal edildi";
    }


}
