package com.javalesson.interfaces;

public class CellPhone extends Electronic {

    public CellPhone(String make, String model, int quantity, int price) {
        super(make, model, quantity, price);
    }

    @Override
    public int calcDeliveryPrice() {
        if (getPrice() >= 150) {
            return 0;
        } else {
            return 10;
        }
    }
}
