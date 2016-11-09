package com.miked;

/**
 * Created by miked on 11/8/2016.
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String name){
        super(name);
    }

    public void playCard(Deck cards){

        MainGame.ui.output(this.name + " is dealt " + handOfCARDS );

    }
}
