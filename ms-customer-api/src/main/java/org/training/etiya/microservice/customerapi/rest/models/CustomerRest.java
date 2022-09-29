package org.training.etiya.microservice.customerapi.rest.models;

import java.security.SecureRandom;
import java.util.Random;

public class CustomerRest {
    private String phoneNumber;
    private String name;
    private String surname;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CustomerRest setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerRest setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public CustomerRest setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public static CustomerRest createRandomCustomer() {
        Random random = new SecureRandom();
        return new CustomerRest().setName("customer" + random.nextInt())
                                 .setSurname("sur" + random.nextInt())
                                 .setPhoneNumber("" + random.nextInt());
    }

    @Override
    public String toString() {
        return "CustomerRest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
