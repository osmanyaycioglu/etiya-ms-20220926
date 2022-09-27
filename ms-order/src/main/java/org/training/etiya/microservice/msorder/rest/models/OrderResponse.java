package org.training.etiya.microservice.msorder.rest.models;

public class OrderResponse {
    private Long orderId;
    private String desc;

    public Long getOrderId() {
        return orderId;
    }

    public OrderResponse setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public OrderResponse setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
