package com.miked;

/**
 * Created by miked on 11/9/2016.
 */
public class Round {

    Deck deck;
    PlayerManager playerManager;

    Round(PlayerManager playerManager){

        deck = new Deck();

        this.playerManager = playerManager;
    }

    public void play(){

        for(Player p : playerManager.getPlayersList()){

            Hand hand = new Hand();
            hand.addCard(deck.deal());
            hand.addCard(deck.deal());
            hand.addCard(deck.deal());
            hand.addCard(deck.deal());
            hand.addCard(deck.deal());
            p.setHandOfCARDS(hand);
        }
    }


}
