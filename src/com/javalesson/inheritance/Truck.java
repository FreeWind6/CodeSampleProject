package com.javalesson.inheritance;

public class Truck extends FuelAuto {

    private int carfoWeight;


    public Truck(String producer, String model, Engine engine, int availablePetrol, int tankVolue, int carfoWeight) {
        super(producer, model, engine, availablePetrol, tankVolue);
        this.carfoWeight = carfoWeight;
        System.out.println("Constracting truck");
    }

    public int getCarfoWeight() {
        return carfoWeight;
    }

    public void setCarfoWeight(int carfoWeight) {
        this.carfoWeight = carfoWeight;
    }

    public void load() {
        System.out.println("Cargo loaded");
    }

    public void unload() {
        System.out.println("Cargo unloaded");
    }

    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);
        System.out.println("Truck is starting");
    }

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(0);
        System.out.println("Truck has stopped");
    }

    @Override
    public void energize() {
        fuelUp(getTankVolue() - getAvailablePetrol());
    }
}
