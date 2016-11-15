package com.miked;

/**
 * Created by miked on 11/8/2016.
 */
public abstract class Player {

    String name;
    Hand handOfCARDS;
    int wins = 0;
    int currentScore = 0;
    boolean isPlayerOne = false;

    Card cardPlayedThisRound;

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }




    Player(String name){
        this.name = name;
        handOfCARDS = new Hand();

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
        //todo needs input validation
    }
    @Override
    public String toString(){
        String playerOne = (isPlayerOne)? "* is currently Player One" : "(is not Player One)";
        return name + " " + playerOne;
    }

    public abstract void play() ;   //todo override and implement this in HumanPlayer and ComputerPlayer
}
