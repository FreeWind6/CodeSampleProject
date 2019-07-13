package com.javalesson.algorithms;

import java.util.Arrays;
import java.util.Comparator;

// Вывести ценность наилучшего набора рюкзака
public class FractionalKnapsack {
    public static void main(String[] args) {
        final Item item1 = new Item(4, 20);
        final Item item2 = new Item(3, 18);
        final Item item3 = new Item(2, 14);

        final Item[] items = {item1, item2, item3};

        // O(N * log(N))
        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());// reversed - сортируем от большего к меньшему по критерию valuePerUnitOfWeight

        System.out.println(Arrays.toString(items));

        final int W = 7;

        int weightSoFar = 0; // аккумулируем текущий вес
        double valueSoFar = 0; // аккумулируем набранную ценность
        int currentItem = 0; // интедс текущего предмета

        while (currentItem < items.length && weightSoFar != W) {
            if (weightSoFar + items[currentItem].getWeight() < W) {
                //берем обьект целиком
                valueSoFar += items[currentItem].getValue();
                weightSoFar += items[currentItem].getWeight();
            } else {
                //берем только часть обьекта
                valueSoFar += ((W - weightSoFar) / (double) items[currentItem].getWeight()) *
                        items[currentItem].getValue();

                weightSoFar = W; // полный рюкзак
            }
            currentItem++;
        }

        System.out.println("Ценность наилучшего набора: " + valueSoFar);
    }
}

class Item {
    private int weight;
    private int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public double valuePerUnitOfWeight() {
        return value / (double) weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{weight = " + weight +
                ", value = " + value + "}";
    }
}
