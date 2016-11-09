package com.miked;

import java.util.ArrayList;

/**
 * Created by miked on 11/8/2016.
 */
public class Hand {

    ArrayList<Card> handOfCards;

    public Hand(){
        this.handOfCards = new ArrayList<Card>();

    }

    public void addCard(Card newCard){
        if(this.handOfCards.size() < 6 ){
            handOfCards.add(newCard);
        }else{
            System.out.println("Only six cards per hand");
        }
    }
    public void playCard(Hand hand){

    }

    public int size(){
        return handOfCards.size();
    }

    public String toString(){
        String cards = "";
        for(Card c:handOfCards){
            cards = cards + c.toString() + " ";
        }
        return cards;
    }
}
