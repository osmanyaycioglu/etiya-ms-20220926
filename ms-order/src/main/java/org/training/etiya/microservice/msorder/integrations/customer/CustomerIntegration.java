package org.training.etiya.microservice.msorder.integrations.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.training.etiya.microservice.customerapi.rest.models.CustomerRest;

@Service
@RefreshScope
public class CustomerIntegration {

    public CustomerIntegration(){
        System.out.println("CustomerIntegration yaratıldı");
    }

    @Autowired
    private ICustomerProvisionIntegration customerProvisionIntegration;
    @Autowired
    private ICustomerQueryIntegration customerQueryIntegration;


    public CustomerRest getCustomer(Long customerId){
        return customerQueryIntegration.getOneCustomer(customerId);
    }

    public CustomerRest getCustomerByNumber(String number){
        return customerQueryIntegration.getCustomerByNumber(number);
    }

}
