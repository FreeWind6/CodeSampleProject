package com.javalesson.interfaces;

public class Fridge extends Electronic {

    public Fridge(String make, String model, int quantity, int price) {
        super(make, model, quantity, price);
    }

    @Override
    public int calcDeliveryPrice() {
        if (getPrice() >= 100) {
            return 0;
        } else {
            return 25;
        }
    }

    @Override
    public int calcOrderPrice() {
        return getQuantity() * getPrice();
    }
}
