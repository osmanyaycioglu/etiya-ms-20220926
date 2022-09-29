package org.training.etiya.microservice.customer.rest;

import org.springframework.web.bind.annotation.*;
import org.training.etiya.microservice.customerapi.rest.ICustomerProvisionController;
import org.training.etiya.microservice.customerapi.rest.models.CustomerRest;

@RestController
public class CustomerProvisionController implements ICustomerProvisionController {

    public Long addCustomer(@RequestBody CustomerRest customerRest) {
        return 100L;
    }

    public String deactivateCustomer(@PathVariable("custId") Long customerId) {
        return "Customer deactivated";
    }
}
