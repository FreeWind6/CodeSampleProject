package com.javalesson.inheritance;

public abstract class FuelAuto extends Auto {

    private int availablePetrol;
    private int tankVolue;

    public FuelAuto(String producer, String model, Engine engine, int availablePetrol, int tankVolue) {
        super(producer, model, engine);
        this.availablePetrol = availablePetrol;
        this.tankVolue = tankVolue;
    }

    void fuelUp(int petrolVolue) {
        availablePetrol += petrolVolue;
        System.out.println("Adding fuel");
    }



    public int getAvailablePetrol() {
        return availablePetrol;
    }

    public void setAvailablePetrol(int availablePetrol) {
        this.availablePetrol = availablePetrol;
    }

    public int getTankVolue() {
        return tankVolue;
    }

    public void setTankVolue(int tankVolue) {
        this.tankVolue = tankVolue;
    }
}
