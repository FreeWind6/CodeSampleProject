package com.javalesson.algorithms;

import java.util.Arrays;
import java.util.Collections;

// Вывести из массива самое большое число
public class GreedyAlgorithms {
    public static void main(String[] args) {
        int[] digits = {3, 1, 7, 9, 9, 5};
        System.out.println(maxNumberFromDigits(digits));
    }

    public static String maxNumberFromDigits(int[] digits) {
//        String.join - первый аргумент разделитель, второй элемент массив (склейка)
        return String.join("", Arrays.stream(digits).boxed()//переводим в поток и используем обертку для сортировки
                .sorted(Collections.reverseOrder())//выполняем обратную сортировку
                .map(String::valueOf)//переводим числа в строки
                .toArray(String[]::new));//переводим стрим в массив строк

        //Вариант решения 2
/*        Arrays.sort(digits);

        String result = "";

        for (int i = digits.length - 1; i >= 0; i--)
            result += digits[i];

        return result;*/
    }
}
