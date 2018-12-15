package com.javacode.collections.arrays;

import java.util.Scanner;

public class ArrayLauncher {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myArray = new int[8];
        System.out.println("Please enter 8 int elements");
        for (int j = 0; j < myArray.length; j++) {
            System.out.println("Next element");
            myArray[j] = scanner.nextInt();
        }

        for (int i = 0; i < myArray.length; i++) {
            System.out.println("Element # " + i + " = " + myArray[i]);
        }
/*        myArray[0] = 0;
        myArray[1] = 100;
        myArray[2] = 200;
        myArray[3] = 300;
        myArray[4] = 400;
        myArray[5] = 500;
        myArray[9] = 900;*/
    }

}
