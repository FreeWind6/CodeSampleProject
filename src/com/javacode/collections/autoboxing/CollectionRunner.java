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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Card card = (Card) o;
            return suit == card.suit &&
                    face == card.face;
        }

        @Override
        public int hashCode() {
            return Objects.hash(suit, face);
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
                return String.valueOf(card1.getSuit()).compareTo(String.valueOf(card2.getSuit()));
            }
            return 0;
        }
    }
}
