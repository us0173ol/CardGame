package com.miked;

/**
 * todo finish this
 *
 */
public class ComputerPlayer extends Player {

    
    public ComputerPlayer(String name ) {
        super(name);
    }

    @Override
    public void play() {

        //todo again, you know what hand the computer has.

        //todo pick a card - the most basic strategy would be
        // simply picking the first card in the hand - but that
        // works to test the flow of the game. You can always
        // upgrade to a more sophisticated strategy later.

        //todo save the selected card

        cardPlayedThisRound = null ;//todo replace null with the card selected

    }
}
