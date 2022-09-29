package org.training.etiya.microservice.msrestaurant.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.training.etiya.microservice.msrestaurant.rest.models.OrderRest;
import org.training.etiya.microservice.msrestaurant.rest.models.PriceInfo;

import java.util.Arrays;
import java.util.List;

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

    @GetMapping("/get/menu")
    public List<PriceInfo> getMenu() {
        return Arrays.asList(new PriceInfo(30D,
                                           "lahmacun"),
                             new PriceInfo(85D,
                                           "kebap"));
    }


}
