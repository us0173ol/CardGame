package com.miked;

/**
 * Created by miked on 11/8/2016.
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String name){
        super(name);
    }



    @Override
    public void play() {

        //todo Human player make their play for one round,

        //todo print the players cards

        //todo ask player to select one

        //todo save in cardPlayedThisRound variable  (defined in the Player superclass)


    }

    public void playCard(Deck cards){

        MainGame.ui.output(this.name + " is dealt " + handOfCARDS );

    }





}
