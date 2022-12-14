package org.training.etiya.microservice.msorder.integrations.restaurant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.training.etiya.microservice.libresterror.ErrorObj;
import org.training.etiya.microservice.msorder.integrations.restaurant.models.PriceInfo;
import org.training.etiya.microservice.msorder.rest.mappings.IOrderMapping;
import org.training.etiya.microservice.msorder.service.models.Order;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class RestaurantIntegration {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private IRestaurantIntg restaurantIntg;

    @Retry(name = "restaurant_retry", fallbackMethod = "calculateOrderFallback")
    public PriceInfo calculateOrder(Order order) {
        try {
            return restTemplate.postForObject("http://API-RESTAURANT/api/v1/restaurant/menu/calculate/price",
                                              IOrderMapping.ordermapper.toOrderRest(order),
                                              PriceInfo.class);
        } catch (HttpStatusCodeException e){
            byte[] responseBodyAsByteArray = e.getResponseBodyAsByteArray();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                ErrorObj errorObj = objectMapper.readValue(responseBodyAsByteArray,
                                                           ErrorObj.class);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return new PriceInfo();
    }
    public PriceInfo calculateOrderFallback(Order order,Throwable th) {
        return new PriceInfo();
    }


    @Retry(name = "restaurant_retry", fallbackMethod = "calculateOrderFallback")
    @CircuitBreaker(name = "restaurant_cb",fallbackMethod = "calculateOrder3Fallback")
    public PriceInfo calculateOrder3(Order order) {
        return restaurantIntg.calculatePrice(IOrderMapping.ordermapper.toOrderRest(order));
    }
    public PriceInfo calculateOrder3Fallback(Order order,Throwable th) {
        return new PriceInfo();
    }
    private AtomicInteger count = new AtomicInteger();

    public PriceInfo calculateOrder2(Order order) {
        int count = this.count.incrementAndGet();
        Application restaurant = eurekaClient.getApplication("API-RESTAURANT");
        List<InstanceInfo> instances = restaurant.getInstances();
        int index = count % instances.size();
        InstanceInfo instanceInfo = instances.get(index);
        RestTemplate rt = new RestTemplate();
        return rt.postForObject("http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/api/v1/restaurant/menu/calculate/price",
                                IOrderMapping.ordermapper.toOrderRest(order),
                                PriceInfo.class);
    }

}
