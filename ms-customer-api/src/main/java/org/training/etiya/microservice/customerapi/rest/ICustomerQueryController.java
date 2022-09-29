package org.training.etiya.microservice.customerapi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.etiya.microservice.customerapi.rest.models.CustomerRest;

import java.util.Arrays;
import java.util.List;

public interface ICustomerQueryController {
    @GetMapping("/api/v1/customer/query/get/one/{cusId}")
    public CustomerRest getOneCustomer(@PathVariable("cusId") Long customerId);

    @GetMapping("/api/v1/customer/query/get/all")
    public List<CustomerRest> getAllCustomers();

    @GetMapping("/api/v1/customer/query/get/by/number")
    public CustomerRest getCustomerByNumber(@RequestParam("phone") String customerNumber);
}
