package com.javacode.collections.set;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetRunner {
    public static void main(String[] args) {
/*        Set - хранит только уникальные эл-ты но не повторяет их при одинаковом названии
*         TreeSet - сортирует эл-ты по алфавиту
*         HashSet - рандомно выводит
*         LinkedHashSet - выводит в том порядке что мы записали
* */
        String[] cars = {"Mini", "Mers", "Audi", "VM", "Smart", "Toyota", "Porsche"};
        String[] otherCars = {"Audi", "Ford", "GMC", "Toyota", "Chevrolet"};

        Set<String> carSet = new TreeSet<>(Arrays.asList(cars));

        Set<String> orherCarSet = new TreeSet<>(Arrays.asList(otherCars));

        Set<String> uniqueCars = new LinkedHashSet<>(carSet);
        uniqueCars.addAll(orherCarSet);

        print(uniqueCars);
    }

    private static void print(Set<String> cars) {
        System.out.println(cars);
    }
}
