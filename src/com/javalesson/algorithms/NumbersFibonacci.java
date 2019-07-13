package com.javalesson.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class NumbersFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число Фиббоначи");
        int n = scanner.nextInt();
//        n = 100;

        // fibEffective
        System.out.println("fibEffective = " + fibEffective(n));

        //fibNaive
        long[] mem = new long[n + 1];
        Arrays.fill(mem, -1);//заполняем весь массив -1
        System.out.println("fibNaive = " + fibNaive(n, mem));
    }

    // наивный, медленный, очевидный
    // O(2^n) - в старой версии (первый алгоритм, не тот что ниже)
    private static long fibNaive(int n, long[] mem) {
        if (n <= 1)
            return n;

        long result = fibNaive(n - 1, mem) + fibNaive(n - 2, mem);
        mem[n] = result;

        return result;
    }

    // быстрый
    // Асимптотическая оценка сложности - O(n)
    private static long fibEffective(int n) {
        long[] arr = new long[n + 1];// O(n)

        arr[0] = 0; // O(1) - потому что нету n
        arr[1] = 1; // O(1)

        for (int i = 2; i <= n; i++)// O(n)
            arr[i] = arr[i - 1] + arr[i - 2];

        return arr[n]; // O(1)
    }
    // O(n) + O(1) + O(1) + O(n) + O(1) = O(2n) + O(3) = O(2n + 3) = O(n)
}
