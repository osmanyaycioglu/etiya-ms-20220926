package org.training.etiya.microservice.customer.rest;

import org.springframework.web.bind.annotation.*;
import org.training.etiya.microservice.customerapi.rest.ICustomerQueryController;
import org.training.etiya.microservice.customerapi.rest.models.CustomerRest;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerQueryController implements ICustomerQueryController {

    public CustomerRest getOneCustomer(@PathVariable("cusId") Long customerId) {
        return CustomerRest.createRandomCustomer();
    }

    public List<CustomerRest> getAllCustomers() {
        return Arrays.asList(CustomerRest.createRandomCustomer(),
                             CustomerRest.createRandomCustomer(),
                             CustomerRest.createRandomCustomer());

    }

    public CustomerRest getCustomerByNumber(@RequestParam("phone") String customerNumber) {
        return CustomerRest.createRandomCustomer()
                           .setPhoneNumber(customerNumber);
    }

}
