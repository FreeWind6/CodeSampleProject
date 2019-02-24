package com.javalesson.collections.StackQueue;

import com.javalesson.collections.autoboxing.Card;
import com.javalesson.collections.autoboxing.CardComparator;

import java.util.*;

public class StackQueueLauncher {
    public static void main(String[] args) {
//        passengerProcessing();

        Queue<Card> cardDeck = new PriorityQueue<>(52, new CardComparator());

        for (Card.Face face : Card.Face.values()) { //добавляем эл-ты в коллекию
            for (Card.Suit suit : Card.Suit.values()) {
                cardDeck.offer(new Card(suit, face));
            }
        }

        Deque<Card> cards = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            cards.offerLast(cardDeck.poll());
        }

/*        for (int i = 0; i < 10; i++) {
            System.out.println(cards.peekLast());
        }*/

        Card card = new Card(Card.Suit.SPADES, Card.Face.TEN);
        cards.removeFirstOccurrence(card);
        cards.removeLastOccurrence(card);

/*        for (int i = 0; i < 10; i++) {
            System.out.println(cardDeck.poll());
        }
        System.out.println("Deck size is " + cardDeck.size());
        System.out.println(cardDeck.peek());

        cardDeck.clear();
        System.out.println("Deck size is " + cardDeck.size());*/


//        q.offer(4); //добаввляем
//        q.offer(5);
//        q.offer(23);
//        q.offer(1);
//
//        System.out.println(q.poll()); //отсортирован и извлечен самый маленький элемент
//        System.out.println(q.poll()); // следующий по старшинству эл-т
    }

    //queue - очередь добавление в конце, удаление/чтение - в начале

    /*  push - добавляет, но не удаляет
     *   pop - добавляет и удаляет
     *   search - возвращает позицию (от последнего к первому)
     * */

    private static void passengerProcessing() {
        Stack<Passenger> bus = new Stack<>(); //стек это коллекция явл похожая на очередь. Работает по принципу - первый кто вошел выходит последним
        Passenger passenger = new Passenger("Ket", "Ma");
        bus.push(new Passenger("Alex", "Vasko"));
        bus.push(new Passenger("sadf", "Vadsagfsko"));
        bus.push(new Passenger("asdf", "sadasdxz"));
        bus.push(passenger);
        bus.push(new Passenger("Ivanov", "Ivan"));

        System.out.println("Passenger found at position " + bus.search(passenger));

        System.out.println("Last is: " + bus.peek());
        while (!bus.empty()) {
            System.out.println("Passenger " + bus.pop());
        }
//        System.out.println(bus.pop());
    }

    private static class Passenger {
        private static int number = 1;
        private String name;
        private String surname;

        public Passenger(String name, String surname) {
            number++;
            this.name = name;
            this.surname = surname;
        }

        public static int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return "Passenger " + name +
                    " " + surname;
        }
    }
}
