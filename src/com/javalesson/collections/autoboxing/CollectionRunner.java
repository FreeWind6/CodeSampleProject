package com.javalesson.collections.autoboxing;

import java.util.*;

public class CollectionRunner {
    public static void main(String[] args) {
        List<Card> deckOfCards = new ArrayList<>();
        for (Card.Face face : Card.Face.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                deckOfCards.add(new Card(suit, face));
            }
        }

        /*System.out.println("Original deck of cards");
        for (int i = 0; i < deckOfCards.size(); i++) {
            System.out.printf("%-20s %s", deckOfCards.get(i), (i + 1) % 4 == 0 ? "\n" : " "); // если (i + 1) % 4 == 0 то переходим на новую строку, если нет то просто пробел
        }*/

        Collections.shuffle(deckOfCards); //перемешали карты

        Collections.sort(deckOfCards);


        Card card = new Card(Card.Suit.SPADES, Card.Face.QUEEN);
        int i = Collections.binarySearch(deckOfCards, card);

        if (i >= 0) {
            System.out.println("Card was found at position " + i);
        } else {
            System.out.println("Cars was not found");
        }

        List<Card> cardList = new ArrayList<>(deckOfCards); //в нашем листе 52 карты
        Collections.fill(cardList, card);
        Collections.addAll(cardList, card, card, card);
        Collections.copy(cardList, deckOfCards);
        int frequency = Collections.frequency(cardList, card);//возвращает количество пиковых дам в колоде

        System.out.println("Frequency of " + card + " is " + frequency);

        System.out.println("MIN: " + Collections.min(cardList));
        System.out.println("MAX: " + Collections.max(cardList));
//        printOutput(cardList);


//        System.out.println("\n\nCard after shuffle");
//        printOutput((List<Card>) deckOfCards);

        Collections.sort(deckOfCards, new CardComparator());
//        System.out.println("\n\nCard after sorting");
//        printOutput(deckOfCards);
//        List<String> colors = new ArrayList<>();
//
//        colors.add("Yellow");
//        colors.add("Blue");
//        colors.add("Green");
//        colors.add("Black");
//        colors.add("Red");
//
//        System.out.println("List before sorting: " + colors); //до сортировки
//        Collections.sort(colors); //сортируем
//        System.out.println("List after sorting: " + colors); //после сортировки
    }

    private static void printOutput(List<Card> deckOfCards) {
        for (int i = 0; i < deckOfCards.size(); i++) {
            System.out.printf("%-20s %s", deckOfCards.get(i), (i + 1) % 4 == 0 ? "\n" : " "); // если (i + 1) % 4 == 0 то переходим на новую строку, если нет то просто пробел
        }
    }

}
