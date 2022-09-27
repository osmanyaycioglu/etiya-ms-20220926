package org.training.etiya.microservice.msorder.rest.models;

import java.util.List;

public class OrderRest {

    private String customerName;
    private String customerNumber;
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
