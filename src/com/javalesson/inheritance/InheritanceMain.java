package com.javalesson.inheritance;

public class InheritanceMain {
    public static void main(String[] args) {

        Engine truckEngine = new Engine(6.0, EngineType.DIESEL, 900);
        Engine busEngine = new Engine(3.5, EngineType.DIESEL, 150);
        Auto bus = new Bus("Mercedes", "Sprinter", busEngine, 30, 75, 12);
        Auto truck = new Truck("Volvo", "VNL 300", truckEngine, 300, 500, 1000);
        Auto car = new ElectricCar("Tesla", "Model S", 4, 100500);
//        Auto auto = new Auto("WV", "Polo", busEngine);

//        bus.start();
//        bus.stop();
//        truck.start();
//        truck.stop();

/*        Engine truckEngine = new Engine(6.0, EngineType.DIESEL, 900);

//        Truck truck = new Truck("Volvo", "VNL 300", truckEngine, 300, 500, 1000);
//        truck.start();
//        truck.accelerate(40);
//        truck.stop();
//        truck.fuelUp(50);
//        truck.load();
//        truck.unload();

        System.out.println("\n");
        ElectricCar car = new ElectricCar("Tesla", "Model S", 4, 100500);
        car.start();
        car.stop();
        car.charge();

        System.out.println("\n");


        Engine busEngine = new Engine(3.5, EngineType.DIESEL, 150);

        Bus bus = new Bus("Mercedes", "Spriner", busEngine, 30, 75, 12);
        bus.fuelUp();
        bus.pickUpPassengers(5);
        bus.start();
        bus.releasePassegers();

        Engine engine = bus.getEngine();
        System.out.println(engine.getEngineType());
        List<Piston> pistons = engine.getPistons();
        System.out.println(pistons);*/
        /*Полиморфизм*/
        runCar(bus);
        runCar(truck);
        runCar(car);
//        runCar(auto);

    }

    private static void runCar(Auto auto) {
        auto.start();
        auto.stop();
        auto.energize();
    }

}
