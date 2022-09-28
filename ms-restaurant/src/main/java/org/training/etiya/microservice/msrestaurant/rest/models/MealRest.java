package org.training.etiya.microservice.msrestaurant.rest.models;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MealRest {
    @NotEmpty
    @Size(min = 2,max = 20)
    private String mealName;
    @DecimalMin("0.5")
    @DecimalMax("5.0")
    private Double amount;

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
