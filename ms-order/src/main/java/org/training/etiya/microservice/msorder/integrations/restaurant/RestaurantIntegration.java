package org.training.etiya.microservice.msorder.integrations.restaurant;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.training.etiya.microservice.msorder.integrations.restaurant.models.PriceInfo;
import org.training.etiya.microservice.msorder.rest.mappings.IOrderMapping;
import org.training.etiya.microservice.msorder.service.models.Order;

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

    public PriceInfo calculateOrder(Order order) {
        return restTemplate.postForObject("http://RESTAURANT/api/v1/restaurant/menu/calculate/price",
                                          IOrderMapping.ordermapper.toOrderRest(order),
                                          PriceInfo.class);
    }

    public PriceInfo calculateOrder3(Order order) {
        return restaurantIntg.calculatePrice(IOrderMapping.ordermapper.toOrderRest(order));
    }

    private AtomicInteger count = new AtomicInteger();

    public PriceInfo calculateOrder2(Order order) {
        int count = this.count.incrementAndGet();
        Application restaurant = eurekaClient.getApplication("RESTAURANT");
        List<InstanceInfo> instances = restaurant.getInstances();
        int index = count % instances.size();
        InstanceInfo instanceInfo = instances.get(index);
        RestTemplate rt = new RestTemplate();
        return rt.postForObject("http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/api/v1/restaurant/menu/calculate/price",
                                IOrderMapping.ordermapper.toOrderRest(order),
                                PriceInfo.class);
    }

}
