package org.training.etiya.microservice.msorder.integrations.restaurant;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.training.etiya.microservice.msorder.integrations.restaurant.models.PriceInfo;
import org.training.etiya.microservice.msorder.rest.models.OrderRest;

import java.util.List;

@FeignClient("API-RESTAURANT")
public interface IRestaurantIntg {

    @PostMapping("/api/v1/restaurant/menu/calculate/price")
    PriceInfo calculatePrice(@RequestBody OrderRest orderRest);

    @GetMapping("/api/v1/restaurant/menu/get/menu")
    List<PriceInfo> getMenu();

}
