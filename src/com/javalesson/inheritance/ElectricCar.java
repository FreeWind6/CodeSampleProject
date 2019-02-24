package com.javalesson.inheritance;

public class ElectricCar extends Auto {

    private int batteryVolue;
    private int passengersNumber;


    public ElectricCar(String producer, String model, int batteryVolue, int passengersNumber) {
        super(producer, model, new Engine());
        this.batteryVolue = batteryVolue;
        this.passengersNumber = passengersNumber;
    }

    private void charge() {
        System.out.println("Battery is charging");
    }

    public int getBatteryVolue() {
        return batteryVolue;
    }

    public void setBatteryVolue(int batteryVolue) {
        this.batteryVolue = batteryVolue;
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    @Override
    public void energize() {
        Auto.doSmth();
        charge();
    }

    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);
        System.out.println("Car is starting");
    }

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(0);
        System.out.println("Car has stopped");
    }

}
