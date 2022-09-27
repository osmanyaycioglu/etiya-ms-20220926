package org.training.etiya.microservice.customer.rest;

import org.springframework.web.bind.annotation.*;
import org.training.etiya.microservice.customer.rest.models.CustomerRest;

@RestController
@RequestMapping("/api/v1/customer/provision")
public class CustomerProvisionController {

    @PostMapping("/add")
    public Long addCustomer(@RequestBody CustomerRest customerRest){
        return 100L;
    }

    @GetMapping("/deactivate/{custId}")
    public String deactivateCustomer(@PathVariable("custId")  Long customerId){
        return "Customer deactivated";
    }
}
