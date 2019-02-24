package com.javalesson.helloWorld.controlstatement;

public class WhileDo {
    public static void main(String[] args) {

        int finalbalance = 100000;
        double currentBalance = 0;
        int payment = 1000;
        int years = 0;
        double interstRate = 0.1;
//while выполняется пока тру, когда станет фолс выполнятся перестанет - неопределенный цикл
        do {
            currentBalance += payment;
            currentBalance = currentBalance + currentBalance * interstRate;
            years++;
            System.out.println("Year " + years + " - " + currentBalance);
        } while (currentBalance < finalbalance && years < 15);

    }
}
