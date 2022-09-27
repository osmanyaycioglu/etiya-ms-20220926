package org.training.etiya.microservice.msorder.rest.models;

public class MealRest {
    private String mealName;
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
