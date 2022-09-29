package org.training.etiya.microservice.msorder.integrations.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.training.etiya.microservice.customerapi.rest.ICustomerProvisionController;

@FeignClient(value = "CUSTOMER",qualifiers = "customerProvision",contextId="customerProvision")
public interface ICustomerProvisionIntegration extends ICustomerProvisionController {
}
