package org.training.etiya.microservice.customerapi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.training.etiya.microservice.customerapi.rest.models.CustomerRest;

public interface ICustomerProvisionController {
    @PostMapping("/api/v1/customer/provision/add")
    public Long addCustomer(@RequestBody CustomerRest customerRest);

    @GetMapping("/api/v1/customer/provision/deactivate/{custId}")
    public String deactivateCustomer(@PathVariable("custId")  Long customerId);
}
