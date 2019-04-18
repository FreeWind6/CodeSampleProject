package com.javalesson.streams;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaAndStreams {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        List<Integer> list1 = new ArrayList<>();

        fillArr(arr1);
        fillList(list1);

        System.out.println(Arrays.toString(arr1));
        System.out.println(list1 + "\n");
//for method - как бы мы делали без map
/*        for (int i = 0; i < 10; i++) { //умножаем каждый элемент на 2
            arr1[i] = arr1[i] * 2;
            list1.set(i, list1.get(i) * 2);
        }*/
//map method - меняет элементы
        arr1 = Arrays.stream(arr1)
                .map(a -> a * 2)//берет элемент с сопоставляет ему новый элемент
                .toArray();//преобразовали в массив(теперь можем прировнять к arr1)
        list1 = list1.stream()
                .map(a -> a * 2)//тоже что и выше. Другими словами мы берем все элементы и умножаем их на 2. Так же как мы это сделали выше в цикле for
                .collect(Collectors.toList());//преобразовали в массив(теперь можем прировнять к list1)

        System.out.println(Arrays.toString(arr1));
        System.out.println(list1 + "\n");

        arr1 = Arrays.stream(arr1)
                .map(a -> 3)
                .toArray();

        System.out.println(Arrays.toString(arr1) + "\n");

        arr1 = Arrays.stream(arr1)
                .map(a -> a + 1)
                .toArray();

        System.out.println(Arrays.toString(arr1) + "\n");

//filter method - фильтрует элементы по заданному параметру
        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();
        fillArr(arr2);
        fillList(list2);

        arr2 = Arrays.stream(arr2)
                .filter(a -> a % 2 == 0)//если деление числа без остатка тру то оставется в результате фильтра
                .toArray();

        list2 = list2.stream()
                .filter(a -> a % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(arr2));
        System.out.println(list2 + "\n");

//forEach method - выводит на экран в цикле
        Arrays.stream(arr2)
                .forEach(a -> System.out.println(a));//вывести все элеменыт а

        list2.stream()
                .forEach(System.out::println);//делает то же самое что и выше

//reduce method - берет набор данных и сжимает их в 1 элемент
        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();
        fillArr(arr3);
        fillList(list3);

        int sum = Arrays.stream(arr3)
                .reduce((acc, b) -> acc + b)//сумма всех элементов
                .getAsInt();//преобразует поток в целое число

        int product = list3.stream()
                .reduce((acc, b) -> acc * b)//произмедение всех элементов
                .get();

        System.out.println("\n" + sum);
        System.out.println(product + "\n");

        //далее

        int[] arr4 = new int[10];
        fillArr(arr4);

        int[] newArray = Arrays.stream(arr4)
                .filter(a -> a % 2 != 0)
                .map(a -> a * 2)
                .toArray();

        System.out.println(Arrays.toString(newArray));
        System.out.println("\n");

//далее
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        System.out.println(set);

        set = set.stream()
                .map(a -> a * 3)
                .collect(Collectors.toSet());
        System.out.println(set);
    }

    //fill
    private static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }
}
