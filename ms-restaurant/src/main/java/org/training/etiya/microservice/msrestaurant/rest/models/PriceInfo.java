package org.training.etiya.microservice.msrestaurant.rest.models;

public class PriceInfo {

    private Double totalPrice;
    private String desc;

    public PriceInfo() {
    }

    public PriceInfo(Double totalPrice,
                     String desc) {
        this.totalPrice = totalPrice;
        this.desc = desc;
    }

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
