package com.javacode.collections.autoboxing;

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

        System.out.println("\n\nCard after shuffle");
        for (int i = 0; i < deckOfCards.size(); i++) {
            System.out.printf("%-20s %s", deckOfCards.get(i), (i + 1) % 4 == 0 ? "\n" : " "); // если (i + 1) % 4 == 0 то переходим на новую строку, если нет то просто пробел
        }

        Collections.sort(deckOfCards, new CardComparator());
        System.out.println("\n\nCard after sorting");
        for (int i = 0; i < deckOfCards.size(); i++) {
            System.out.printf("%-20s %s", deckOfCards.get(i), (i + 1) % 4 == 0 ? "\n" : " "); // если (i + 1) % 4 == 0 то переходим на новую строку, если нет то просто пробел
        }
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

    public static class Card implements Comparable<Card> {


        private final Suit suit;
        private final Face face;

        public Card(Suit suit, Face face) {
            this.suit = suit;
            this.face = face;
        }

        public Suit getSuit() {
            return suit;
        }

        public Face getFace() {
            return face;
        }

        @Override
        public int compareTo(Card card) {
            Face[] values = Face.values(); //преобразуем эман в массив
            List<Face> faces = Arrays.asList(values); //получаем список

            if (faces.indexOf(this.face) < faces.indexOf(card.getFace())) {
                return -1;
            } else if (faces.indexOf(this.face) > faces.indexOf(card.getFace())) {
                return +1;
            } else if (faces.indexOf(this.face) == faces.indexOf(card.getFace())) {
                return String.valueOf(suit).compareTo(String.valueOf(card.getSuit()));
            }
            return 0;
        }

        @Override
        public String toString() {
            return face + " of " + suit;
        }

        private enum Suit {SPADES, HEARTS, CLUBS, DIMONDS}

        private enum Face {ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}
    }

    public static class CardComparator implements Comparator<Card> {
        List<Card.Face> faces = Arrays.asList(Card.Face.values()); //получаем список

        @Override
        public int compare(Card card1, Card card2) {
            if (faces.indexOf(card1.getFace()) < faces.indexOf(card2.getFace())) {
                return 1;
            } else if (faces.indexOf(card1.getFace()) > faces.indexOf(card2.getFace())) {
                return -1;
            } else if (faces.indexOf(card1.getFace()) == faces.indexOf(card2.getFace())) {
                return 0;
            }
            return 0;
        }
    }
}
