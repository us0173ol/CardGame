package com.miked;

import java.util.ArrayList;

/**
 * Created by miked on 11/8/2016.
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String name){
        super(name);
    }


    //ArrayList<Card> firstTrick = new ArrayList<>();
    @Override
    public void play() {

       // Card playedCard = handOfCARDS.playCard();



        //todo Human player make their play for one round,
//        if (this.handOfCARDS != null) {
//
//            System.out.println(this.name + " has " + handOfCARDS.toString());
//        }
        //cardPlayedThisRound = playedCard;

        //firstTrick.add(cardPlayedThisRound);
        //System.out.println("Trick 1-" + firstTrick.toString());
        //todo print the players cards

        //todo ask player to select one

        //todo save in cardPlayedThisRound variable  (defined in the Player superclass)

    }


    public void playCard(Deck cards){

        MainGame.ui.output(this.name + " is dealt " + handOfCARDS );

    }





}
