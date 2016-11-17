package com.miked;

/**
 * Created by miked on 11/8/2016.
 */
public class Card {

    String suit;
    int value;
    boolean alpha = false;//alpha is the cards suit for each trick

    public enum Suit{
        CLUBS("Clubs"),HEARTS("Hearts"),DIAMONDS("Diamonds"),SPADES("Spades");
        private String value;
        Suit(String value){
            this.value = value;
        }
    }
    public boolean isAlpha(){ return alpha; }

    public void setAlpha(boolean alpha){ this.alpha = alpha; }

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
    //displays aces as "Ace" instead of 11
    public String toString(){
        if(this.value == 11){
            return "Ace of " + this.suit;
        }
        return this.value + " of " + this.suit;
    }

    @Override
    public boolean equals(Object other){

        Card anotherCard;

        try{
            anotherCard = (Card) other;
        }catch (ClassCastException cce){
            return false;
        }

        if(this.value == anotherCard.value &&
                this.suit.equals(anotherCard.suit));
        return true;
    }
}

