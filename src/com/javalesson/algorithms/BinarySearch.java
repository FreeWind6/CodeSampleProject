package com.javalesson.algorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {-1, 2, 9, 4, 7, 50, 7};
        int key = 50;
        System.out.println(binarySearch(a, key));

    }

    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;//последний элемент в массиве

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (key < a[middle]) {
                high = middle - 1;
            } else if (key > a[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
