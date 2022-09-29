package org.training.etiya.microservice.msorder.integrations.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.training.etiya.microservice.customerapi.rest.ICustomerQueryController;

@FeignClient(value = "CUSTOMER", qualifiers = "customerQuery", contextId = "customerQuery")
public interface ICustomerQueryIntegration extends ICustomerQueryController {
}
