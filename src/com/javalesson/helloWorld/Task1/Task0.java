package com.javalesson.helloWorld.Task1;


/**
 * Создайте программу, которая будет принимать две группы параметров:
 * - количество циклов выполнения программы;
 * - 3 числа a, b, n
 * и выводить на экран последовательность результатов вычисления следующего выражения
 * (a + 2^0*b),(a + 2^0*b + 2^1*b),(a + 2^0*b + 2^1*b + 2^2*b)..., (a+2^0*b + 2^1*b + 2^2*b +...+ 2^(n-1)*b)
 * где ^ обозначает возведение в степень, и эта операция выполняется до умножения.
 * <p>
 * Пример:
 * Please enter the number of iterations
 * 2
 * Enter the group of 3 numbers
 * 0 2 10
 * Output:
 * 2 6 14 30 62 126 254 510 1022 2046
 * Enter the group of 3 numbers
 * 5 3 5
 * Output:
 * 8 14 26 50 98
 * <p>
 * Пример:
 * a=5, b=3, n=5
 * (5+2^0*3)=8,(5+2^0*3 + 2^1*3)=14,(5+2^0*3 + 2^1*3 + 2^2*3)=26,(5+2^0*3 + 2^1*3 + 2^2*3 + 2^3*3)=50,
 * (5+2^0*3 + 2^1*3 + 2^2*3 + 2^3*3 + 2^4*3)=98
 */

public class Task0 {
    public static void main(String[] args) {
        int i = 2;
        System.out.println("Число итераций = " + i);
        int a = 0;
        int b = 2;
        int n = 10;

        System.out.println("Три числа: a = " + a + " b = " + b + " n =" + n);
        double степень = Math.pow(2, 0);
        double степень2 = Math.pow(2, 1);
        for (int z=0;z<i;z++){
            System.out.println("(a + 2^0*b) = " + (a + степень * b));
            System.out.println("(a + 2^0*b + 2^1*b) = "+((a + степень*b + степень2*b)));
        }

    }
}
