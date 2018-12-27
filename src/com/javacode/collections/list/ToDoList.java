package com.javacode.collections.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ToDoList {
    //    private List<String> toDoList = new ArrayList<>();
    private LinkedList<String> toDoList = new LinkedList<>();

    public void addToList(String task) {
//        toDoList.add(task); //добавили в toDoList наш task
        addInAlphabeticalOrder(task);
    }

    private boolean addInAlphabeticalOrder(String task) {
        ListIterator<String> listIter = toDoList.listIterator();
        while (listIter.hasNext()) { //пока в нашем лист итераторе есть переменные. hasNext - проверяет есть ли эл-ты в нашем списке
            int compared = listIter.next().compareTo(task);
            if (compared == 0) {
                System.out.println("Task already exist if the list");
                return true;
            } else if (compared > 0) {
                listIter.previous();
                listIter.add(task);
                return true;
            }
        }
        toDoList.add(task);
        return true;
    }

    /*public void addToList(String task) {
        toDoList.addFirst(task); //добавили в toDoList наш task на первую позицию командой addFirst
    }*/

    public void addToListAtPosition(int position, String task) {
        toDoList.add(position, task);
    }

    public void printToDoList() {
//        for (int i = 0; i < toDoList.size(); i++) {
//            System.out.println(i + " - " + toDoList.get(i));
//        } //тоже самое
        Iterator<String> iterator = toDoList.iterator();
        while (iterator.hasNext()) {
            System.out.println("Element " + iterator.next());
        }
    }

    public void changeTask(int index, String task) {
        toDoList.set(index, task);
    }

    public void removeTask(String task) {
        toDoList.remove(task);
    }

    public int getTaskPriority(String task) {
        return toDoList.indexOf(task);
    }
}
