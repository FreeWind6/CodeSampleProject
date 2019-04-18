package com.javalesson.regularexpressionslesson;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        //разделить слова по пробелам
        String a = "Hello there hey!";
        String[] words = a.split(" ");
        System.out.println(Arrays.toString(words));

        //разделить слова по точкам
        String b = "Hello.there.hey!";
        String[] words2 = b.split("\\.");
        System.out.println(Arrays.toString(words2));

        String c = "Hello34asdasdas123123ther434ehfadsfsey!";
        String[] words3 = c.split("\\d+");
        System.out.println(Arrays.toString(words3));

        //заменяем все пробелы на точки
        String d = "Hello there hey!";
        String replace = d.replaceAll(" ", ".");
        String replace2 = d.replaceFirst(" ", ".");//меняет только первое
        System.out.println(replace);
        System.out.println(replace2);
    }
}
