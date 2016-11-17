package com.miked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.miked.Card.Suit.SPADES;

/**
 * Created by miked on 11/8/2016.
 */
public class Deck {

    public ArrayList<Card> cards;

    protected Random rng;

    public void setRng(Random rng){
        this.rng = rng;
    }

    public Deck(){
        //random number generator
        rng = new Random();

        this.cards = new ArrayList<Card>();

        for(Card.Suit suit: Card.Suit.values()){
            /*add values to cards for each suit
            * since there are no face cards in Agram
            * I assigned 11 to Ace so Aces are high*/
            for (int v = 3; v <=11; v++){
                Card c = new Card(v, suit.toString());
                cards.add(c);
            }

        }//easy way to remove the Ace of SPADES since it is the
        //last card added to the deck
        cards.remove(35);
        //showDeck(); TESTING
        //shuffle the deck
        Collections.shuffle(cards);
        //showDeck(); TESTING
    }


    public int cardsLeft(){
        return cards.size();
    }

    public Card deal(){
        int cardsLeft = this.cards.size();
        int cardPicked = rng.nextInt(cardsLeft);
        return cards.remove(cardPicked);
    }
    //used this for testing to see what was happening with the deck
    public ArrayList showDeck(){
        for(Card c: cards){
            System.out.println(c);
        }
        return cards;
    }

}
