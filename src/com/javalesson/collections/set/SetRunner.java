package com.javalesson.collections.set;

import java.util.*;

public class SetRunner {
    public static void main(String[] args) {
        /*        Set - хранит только уникальные эл-ты но не повторяет их при одинаковом названии
         *         TreeSet - сортирует эл-ты по алфавиту
         *         HashSet - рандомно выводит
         *         LinkedHashSet - выводит в том порядке что мы записали
         *         Queue - первый зашел - первый вышел
         *         Stack - последний зашел - первый вышел
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
        europaCars.add(new Car("VW", "Polo", 35));

        NavigableSet<Car> uniqueCars = new TreeSet<>(sixCars);
        uniqueCars.addAll(europaCars); //обьединение
//        print(uniqueCars);

//        sixCars.removeAll(europaCars); //разность
//        europaCars.removeAll(sixCars);
//        print(sixCars);
//        print(europaCars);
//
//        sixCars.retainAll(europaCars); //пересечение
//        uniqueCars.removeAll(sixCars);
//        SortedSet<Car> cars = uniqueCars.headSet(new Car("Toyota", "Auris", 40));//возвращает все элементы от начала до указанного эл-та
        SortedSet<Car> cars = uniqueCars.subSet(new Car("Toyota", "Auris", 40), true, new Car("Audi", "A3", 60), true);

        print(uniqueCars);

        System.out.println("\nHigher");
        System.out.println(uniqueCars.higher(new Car("Toyota", "Auris", 40)));

        System.out.println("\nLower");
        System.out.println(uniqueCars.lower(new Car("Toyota", "Auris", 40)));

        System.out.println("\nCeiling");
        System.out.println(uniqueCars.ceiling(new Car("Toyota", "Auris", 43)));

        System.out.println("\nFloor");
        System.out.println(uniqueCars.floor(new Car("Toyota", "Auris", 39)));


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
