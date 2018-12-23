package com.javacode.collections.list;

import java.util.Scanner;

public class ListRunner {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
/*        //ситуация: у нас есть массив длинной в 5 символов, а нам нужно добавить 7 символ. для этого создаем новый массив и копируем уже существующий в него. Далее добавляем нужный 7 элемент.
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        }

        int[] nArray = new int[10];
        System.arraycopy(array, 0, nArray, 0, array.length);
        nArray[6] = 100;
        System.out.println(Arrays.toString(nArray));
    }*/
        ToDoList list = new ToDoList();
        printOut();
        int param = scanner.nextInt();
        while (param != 0) { //выполняем пока param введенный с клавиатуры не равен 0
            switch (param) {
                case 1:
                    System.out.println("Please enter a task to add");
                    scanner.nextLine();
                    String task1 = scanner.nextLine();
                    list.addToList(task1);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 2:
                    System.out.println("Printing out TO DO LIST");
                    list.printToDoList();
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("Please enter an item to update");
                    scanner.nextLine();
                    int i = scanner.nextInt();
                    System.out.println("Please enter a new task");
                    scanner.nextLine();
                    String task3 = scanner.nextLine();
                    list.changeTask(i, task3);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 4:
                    System.out.println("Please enter a task to remove");
                    scanner.nextLine();
                    String task4 = scanner.nextLine();
                    list.removeTask(task4);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 5:
                    System.out.println("Please enter a task to get priority");
                    scanner.nextLine();
                    String task5 = scanner.nextLine();
                    System.out.println("Priority of the task is: " + list.getTaskPriority(task5));
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 6:
                    System.out.println("Please enter a number of position for the task");
                    scanner.nextLine();
                    int index = scanner.nextInt();
                    System.out.println("Please enter a new task");
                    String task6 = scanner.nextLine();
                    list.changeTask(index, task6);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                default:
                    param = 0;
            }
        }
    }

    private static void printOut() {
        System.out.println("Please choose an action. Press :\n"
                + "1 to add a new item into ToDoList\n" //добавляем item(задача) в ToDoList
                + "2 to print out the list\n" //выводим ToDOList
                + "3 to update an existing item\n" //обновить существующую запись
                + "4 to remove an item form the list\n" //удаляет задачи
                + "5 to get task priority or number in the list\n" //выводит номер нашей задачи в списке
                + "6 to add a new item at specific position\n" //обновляет задачу в определенной позиции
                + "press 0 for exit\n\n"
                + "AFTER CHOOSING AN OPTION PLEASE PRESS ENTER");
    }
}
