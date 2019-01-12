package com.javacode.collections.set;

import java.util.HashSet;
import java.util.Set;

public class SetRunner {
    public static void main(String[] args) {
        /*        Set - хранит только уникальные эл-ты но не повторяет их при одинаковом названии
         *         TreeSet - сортирует эл-ты по алфавиту
         *         HashSet - рандомно выводит
         *         LinkedHashSet - выводит в том порядке что мы записали
         * */
/*        String[] cars = {"Mini", "Mers", "Audi", "VM", "Smart", "Toyota", "Porsche"};
        String[] otherCars = {"Audi", "Ford", "GMC", "Toyota", "Chevrolet"};

        Set<String> carSet = new TreeSet<>(Arrays.asList(cars));

        Set<String> orherCarSet = new TreeSet<>(Arrays.asList(otherCars));

        Set<String> uniqueCars = new LinkedHashSet<>(carSet);
        uniqueCars.addAll(orherCarSet);

        print(uniqueCars);*/

        Set<Car> sixCars = new HashSet<>();
        sixCars.add(new Car("VW", "Golf", 45));
        sixCars.add(new Car("Audi", "A3", 60));
        sixCars.add(new Car("VM", "Polo", 25));
        sixCars.add(new Car("BMW", "Z4", 120));
        sixCars.add(new Car("BMW", "440i", 200));

        Set<Car> europaCars = new HashSet<>();
        europaCars.add(new Car("Toyota", "Auris", 40));
        europaCars.add(new Car("Reno", "Logan", 30));
        europaCars.add(new Car("Reno", "Megan", 50));
        europaCars.add(new Car("VW", "Golf", 45));
        europaCars.add(new Car("VM", "Polo", 35));

        Set<Car> uniqueCars = new HashSet<>(sixCars);
        uniqueCars.addAll(europaCars);
        print(uniqueCars);


    }

    private static void print(Set<Car> cars) {
        System.out.printf("%-20s %-20s %-20s \n", "Car brand", "Model", "Price per day");
//        -20 это отступ
//        s - это тип, стринговое значение
        for (Car car : cars) {
            System.out.printf("%-20s %-20s %-20s \n", car.getCarBrand(), car.getModel(), car.getPricePerDay());
        }
    }
}