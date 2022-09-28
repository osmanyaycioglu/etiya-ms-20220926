package org.training.etiya.microservice.msorder.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training.etiya.microservice.libresterror.ErrorObj;
import org.training.etiya.microservice.msorder.rest.mappings.IOrderMapping;
import org.training.etiya.microservice.msorder.rest.models.OrderResponse;
import org.training.etiya.microservice.msorder.rest.models.OrderRest;
import org.training.etiya.microservice.msorder.service.OrderService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api/v1/order/management")
@Valid
public class OrderManagementController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    @Operation(summary = "Sipariş vermek için kulllanılır.", tags = "order-management", description = "Müşteri bilgisiyle başka bir sistemden sipariş verme")
    public OrderResponse place(@Valid @RequestBody OrderRest orderRest) {
        if (orderRest.getCustomerName() == null) {
            throw new IllegalArgumentException("Müşteri ismi boş olamaz");
        }
        Long aLong = orderService.placeOrder(IOrderMapping.ordermapper.toOrder(orderRest));
        return new OrderResponse().setOrderId(aLong)
                                  .setDesc("Siparişiniz alındı 30 dk sonra gönderilecek");
    }
    @PostMapping("/place2")
    public OrderResponse place2(@Valid @RequestBody OrderRest orderRest) {
        Long aLong = orderService.placeOrder2(IOrderMapping.ordermapper.toOrder(orderRest));
        return new OrderResponse().setOrderId(aLong)
                                  .setDesc("Siparişiniz alındı 30 dk sonra gönderilecek");
    }

    @PostMapping("/place3")
    public OrderResponse place3(@Valid @RequestBody OrderRest orderRest) {
        Long aLong = orderService.placeOrder3(IOrderMapping.ordermapper.toOrder(orderRest));
        return new OrderResponse().setOrderId(aLong)
                                  .setDesc("Siparişiniz alındı 30 dk sonra gönderilecek");
    }

    @GetMapping("/cancel")
    public String cancel(@Positive @Min(10) @RequestParam("oid") Long orderId) {
        orderService.cancelOrder(orderId);
        return "Siparişiniz iptal edildi";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(IllegalArgumentException exception) {
        return new ErrorObj().setErrorCode(1048)
                             .setDesc("Validasyon problemi : " + exception.getMessage());
    }

}
