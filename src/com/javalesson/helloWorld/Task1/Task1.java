package com.javalesson.helloWorld.Task1;

import java.util.Scanner;

/**
 * Напишите программу которая принимает 3 числовых значения и проверяет, могут ли они быть
 * сторонами треугольника.
 * Для ввода значений с консоли Вам понадобится класс Scanner.
 * <code>Scanner scanner = new Scanner(System.in);</code>
 * <code>scanner.nextInt();</code>
 */

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите 3 числа");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        int big;
        if (a > b) {
            big = a;
        } else {
            big = b;
        }

        if (c > big) {
            big = c;
        }

        if (a > b + c){
            System.out.println("Такой треугольник невозможен1");
        } else{
            System.out.println("Треугол возможен1");

        }
        if (b>a+c){
            System.out.println("Такой треугольник невозможен2");
        } else{
            System.out.println("Треугол возможен2");
        }
        if (c>a+b){
            System.out.println("Такой треугольник невозможен3");
        } else{
            System.out.println("Треугол возможен3");
        }
    }
}
