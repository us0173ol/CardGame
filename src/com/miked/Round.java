package com.miked;

import java.util.ArrayList;

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

        //now play game here
        ArrayList<Card> firstTrick = new ArrayList<>();
        for (Player p : playerManager.getPlayersList()) {

            p.play();


        }

        //figure out winner

        Player winner = playerManager.findWinner();

        System.out.println("the winner is " + winner);



    }


}
