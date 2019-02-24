package com.javalesson.helloWorld.operators;

public class operators {

    public static void main(String[] args) {
//        + - / * %
        double a = 10;
        double b = 3;

        double c = a + b;
        double d = a - b;

        double e = a * b;
        double f = a / b;

        double g = a % b;

        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        System.out.println("f = " + f);
        System.out.println("g = " + g);


//        a = a + 5; одно и тоже
//        a += 5; одно и тоже
//        a /= 5;
        ++a; // одно и тоже
//        System.out.println("New a = " + a);


        --b; // одно и тоже только минус 1
//        System.out.println("New b = " + b);

        double n = 7;
        double m = 7;

        double resl1 = 2 * n++;
        double resl2 = 2 * ++m;

//        System.out.println("resl1 = " + resl1);
//        System.out.println("resl2 = " + resl2);

//        == равно
//        != не равно
//        < меньше
//        > больше
//        <=
//        >=
//        && и (первое и второе значение равно тру тогда и значение равно тру)
//        || или (одна из сторон тру тогда = тру)
//        ?: итернарный оператор

        int x = 3;
        int y = 5;
        int z = 8;

        boolean boolVal = n >= m;
        System.out.println("Boolval = " + boolVal);

        boolean boolVal2 = y > z;

        boolean resultBoolean = boolVal || boolVal2;

//        true %% true = true
//        true %% false = false
//        true || false = true
//        false || false = false

        System.out.println("ResultBoolean = " + resultBoolean);

        int res = (x > y) && (z < y) ? x : y; // если тру то x если фолсе то y

        System.out.println("Ternary res = " + res);

        System.out.println("NOT = " + !(x > y)); //противоположный результат
    }

}
