package com.miked;

/**
 * Created by miked on 11/8/2016.
 */
public abstract class Player {

    String name;
    Hand handOfCARDS;

    boolean isPlayerOne = false;

    Card cardPlayedThisRound;


    Player(String name){
        this.name = name;

    }

    public Card getCardPlayedThisRound() {
        return cardPlayedThisRound;
    }

    public void setCardPlayedThisRound(Card cardPlayedThisRound) {
        this.cardPlayedThisRound = cardPlayedThisRound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHandOfCARDS() {
        return handOfCARDS;
    }

    public void setHandOfCARDS(Hand handOfCARDS) {
        this.handOfCARDS = handOfCARDS;
    }
    public boolean isPlayerOne(){
        return isPlayerOne;
    }
    public void setPlayerOne(boolean playerOne){
        isPlayerOne = playerOne;
    }
    public Card humanSelectCardToPlay(){
        handOfCARDS.displayHand();
        String prompt = "Please select a card to play";
        int userChoice = MainGame.ui.numInput(prompt);
        Card selectedCard = handOfCARDS.playCard(userChoice);
        return selectedCard;
    }
    @Override
    public String toString(){
        String playerOne = (isPlayerOne)? "* is currently Player One" : "(is not Player One)";
        return name + " " + playerOne;
    }

    public abstract void play() ;   //todo override and implement this in HumanPlayer and ComputerPlayer
}
