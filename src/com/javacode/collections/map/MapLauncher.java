package com.javacode.collections.map;

import java.util.*;

public class MapLauncher {
    public static void main(String[] args) {
/*        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("Toyota", 50);
        numbers.put("Audi", 51);
        System.out.println(numbers.put("Toyota", 52));*/

//        System.out.println(numbers.get(new Car("Audi", "A5", 50)));
        Map<String, Integer> wordMap = new HashMap<>();
        System.out.println("Please enter some text");
        Scanner scaner = new Scanner(System.in);
        String string = scaner.nextLine();
        String[] tokens = string.split(" ");
        for (String token : tokens) {
            String word = token.toLowerCase();
            Integer count = wordMap.get(word);
            if (count == null) {
                wordMap.put(word, 1);
            } else {
                wordMap.put(word, count + 1);
            }
        }
        Set<WordWrapper> wordWrappers = convertToSet(wordMap);
        wordWrappers.add(new WordWrapper(" ", 234));
//        printSet(wordWrappers);
    }

    private static void printSet(NavigableSet<WordWrapper> wordWrappers) {
        for (WordWrapper wordWrapper : wordWrappers) {
            System.out.println(wordWrapper);
        }
    }


    private static Set<WordWrapper> convertToSet(Map<String, Integer> wordMap) {
        wordMap.remove("a");
        wordMap.remove("the", 9);
        wordMap.replace("the", 9, 0);
        NavigableSet<WordWrapper> wordSet = new TreeSet<>();
        for (Map.Entry<String, Integer> e : wordMap.entrySet()) {
            wordSet.add(new WordWrapper(e.getKey(), e.getValue()));
        }
        return Collections.unmodifiableSortedSet(wordSet);
    }


}
