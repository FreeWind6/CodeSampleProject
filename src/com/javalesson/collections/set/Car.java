package com.javalesson.collections.set;

public final class Car implements Comparable<Car> {
    private final String carBrand;
    private final String model;
    private final Integer pricePerDay;

//    если они final то нужен конструктор, иначе ошибка компиляции

    public Car(String carBrand, String model, int pricePerDay) {
        this.carBrand = carBrand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getModel() {
        return model;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        if (!this.carBrand.equals(car.getCarBrand())) {
            return false;
        }
        if (!this.model.equals(car.getModel())) {
            return false;
        }
        return this.pricePerDay.equals(car.getPricePerDay());
    }

    //  x.equals(x) = true рефлексивность
//  x.equals(y) = true y.equals(x) = true = симетрия
//  a = b and b = c then a = c транзитивность
    @Override
    public int hashCode() {
        int result = carBrand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + pricePerDay.hashCode();
        return result;
    }

    @Override
    public int compareTo(Car car) {
        if (pricePerDay < car.getPricePerDay()) {
            return -1;
        }
        if (pricePerDay > car.getPricePerDay()) {
            return +1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return carBrand + " " + model + " " + pricePerDay;
    }
}
