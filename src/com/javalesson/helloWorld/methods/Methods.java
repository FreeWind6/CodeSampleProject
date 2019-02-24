package com.javalesson.helloWorld.methods;

public class Methods {
    public static void main(String[] args) {
        printMessage("Alex");
        System.out.println("Rectangle square = " + calcRectangleSquare(5, 10));
        System.out.println("Square = " + calcSquare(5));
        System.out.println("Sam Of Squares = " + (calcRectangleSquare(5, 10) + calcSquare(10)));

        String str1 = "I like black coffee";
        String str3 = "I like coffee!!!";

        System.out.println(str1.toUpperCase()); //верхний регастр
        System.out.println(str1.toLowerCase()); //нижний регистр

        String str2 = "I like coffee";
        String str4 = new String("I like coffee");


        String substring = str3.substring(0, 13); //substring - позволяет выводить фразу от символа до символа
        System.out.println("Substring = " +substring);
//        boolean b = str2.equals(substring); //для сравнение str2 и substring или str2 и str4
//        System.out.println(b);

        boolean like = str1.endsWith("fee!");
        //tartsWith - начинается ли сторока str1 с символов I like, сколько символов отступить до начала
        //endsWith - c конца
        System.out.println(like);

        System.out.println(str1.replace("black", "white"));
        //replace - что заменить на что заменить
        System.out.println(str3.indexOf("abc"));
        //str3.indexOf("!!!") - с какой позиции начинается !!!
        //str3.indexOf("abc") - -1 значит нету такого



    }

    private static void printMessage(String name) {

        System.out.println("Hellow " + name + "!!");
    }

    static int calcRectangleSquare(int x, int y) {
        int square = x * y;
        return square; // возвращаем square = x * y
    }

    static int calcSquare(int x) {

        return x * x; //возвращаем x * x
    }
}
