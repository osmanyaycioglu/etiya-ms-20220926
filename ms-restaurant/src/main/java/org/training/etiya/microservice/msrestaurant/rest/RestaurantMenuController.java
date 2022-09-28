package org.training.etiya.microservice.msrestaurant.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.etiya.microservice.msrestaurant.rest.models.OrderRest;
import org.training.etiya.microservice.msrestaurant.rest.models.PriceInfo;

@RestController
@RequestMapping("/api/v1/restaurant/menu")
public class RestaurantMenuController {

    @Value("${server.port}")
    private int port;

    @PostMapping("/calculate/price")
    public PriceInfo calculatePrice(@RequestBody OrderRest orderRest) {
        PriceInfo priceInfo = new PriceInfo();
        priceInfo.setTotalPrice(100D);
        priceInfo.setDesc("Result from : " + port);
        return priceInfo;
    }

}
