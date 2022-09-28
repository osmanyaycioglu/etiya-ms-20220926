package org.training.etiya.microservice.msrestaurant.rest.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class OrderRest {
    @NotNull(message = "Müşteri ismi boş olamaz")
    @NotEmpty
    @NotBlank
    @Size(min = 2,max = 15,message = "İsim {min} ile {max} arasında olmalı")
    // @Startwith(value = "n:",message = "customerName {value} ile başlamalı")
    private String customerName;
    @NotEmpty
    @Size(min = 2,max = 15,message = "İsim {min} ile {max} arasında olmalı")
    // @Startwith("p:")
    private String         customerNumber;
    @Size(min = 1)
    @Valid
    private List<MealRest> meals;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public List<MealRest> getMeals() {
        return meals;
    }

    public void setMeals(List<MealRest> meals) {
        this.meals = meals;
    }
}
