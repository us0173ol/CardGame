package com.miked;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by miked on 11/8/2016.
 */
public class Deck {

    private ArrayList<Card> cards;

    protected Random rng;

    public void setRng(Random rng){
        this.rng = rng;
    }

    public Deck(){

        rng = new Random();

        this.cards = new ArrayList<Card>();

        for(Card.Suit suit: Card.Suit.values()){

            for (int v = 3; v <=11; v++){
                Card c = new Card(v, suit.toString());
                cards.add(c);
            }

        }
    }

    public int cardsLeft(){
        return cards.size();
    }

    public Card deal(){
        int cardsLeft = this.cards.size();
        int cardPicked = rng.nextInt(cardsLeft);
        return cards.remove(cardPicked);
    }
    public ArrayList showDeck(){
        for(Card c: cards){
            System.out.println(c);
        }
        return cards;
    }

}
