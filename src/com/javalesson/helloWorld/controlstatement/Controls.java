package com.javalesson.helloWorld.controlstatement;

public class Controls {

    public static void main(String[] args) {

        int i = 10;
        { //код блок начало
            int k = 15;
            System.out.println("I = " + i);
            System.out.println("K = " + k);
        } //конец код блока

        int testScore = 65;
        System.out.println("You`ve got");

        if (testScore >= 90) {
            System.out.println("an Excellent");
        } else if (testScore >= 75) {
            System.out.println("a Good");
        } else if (testScore >= 60) {
            System.out.println("a Satisfactory");
        } else {
            System.out.println("an bad");
        }
        System.out.println("mark");

    }
}
