package com.miked;

/**
 * Created by miked on 11/8/2016.
 */
public class Card {

    String suit;
    int value;

    public enum Suit{
        CLUBS("Clubs"),HEARTS("Hearts"),DIAMONDS("Diamonds"),SPADES("Spades");
        private String value;
        Suit(String value){
            this.value = value;
        }
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Card(int v, String s){
        this.suit = s;
        this.value = v;

    }

    public String toString(){
        if(this.value == 11){
            return "Ace of " + this.suit;
        }
        return this.value + " of " + this.suit;
    }
    //// TODO: 11/8/2016 maybe add a boolean equals to compare cards
}

