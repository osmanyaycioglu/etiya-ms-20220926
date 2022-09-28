package org.training.etiya.microservice.msrestaurant.rest.models;

public class PriceInfo {

    private Double totalPrice;
    private String desc;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
