package org.training.etiya.microservice.customer.rest;

import org.springframework.web.bind.annotation.*;
import org.training.etiya.microservice.customer.rest.models.CustomerRest;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/query")
public class CustomerQueryController {

    @GetMapping("/get/one/{cusId}")
    public CustomerRest getOneCustomer(@PathVariable("cusId") Long customerId) {
        return CustomerRest.createRandomCustomer();
    }

    @GetMapping("/get/all")
    public List<CustomerRest> getAllCustomers() {
        return Arrays.asList(CustomerRest.createRandomCustomer(),
                             CustomerRest.createRandomCustomer(),
                             CustomerRest.createRandomCustomer());

    }

    @GetMapping("/get/by/number")
    public CustomerRest getCustomerByNumber(@RequestParam("phone") String customerNumber) {
        return CustomerRest.createRandomCustomer()
                           .setPhoneNumber(customerNumber);
    }

}
