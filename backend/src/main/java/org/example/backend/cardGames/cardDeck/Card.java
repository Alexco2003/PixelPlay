package org.example.backend.cardGames.cardDeck;

import java.util.Objects;

public class Card {

    private final String suit;
    private final String value;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    public boolean hasSameSuit(Card card) {
        return this.suit.equals(card.suit);
    }

    public boolean hasSameValue(Card card) {
        return this.value.equals(card.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return suit.equals(card.suit) && value.equals(card.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
