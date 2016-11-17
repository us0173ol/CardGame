package com.miked;

/**
 * Created by miked on 11/8/2016.
 */
public abstract class Player {
    //attributes of a player
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
    }//Player method for allowing a human controlled player to select
    //the card they want to play
    public Card humanSelectCardToPlay(){
        while (true) {
            handOfCARDS.displayHand();//show cards
            String prompt = "Please select a card to play";
            int userChoice = MainGame.ui.numInput(prompt);
            if (userChoice <= handOfCARDS.size()) {
                Card selectedCard = handOfCARDS.playCard(userChoice);
                return selectedCard;
            } else {//if the choice is invalid, notify player and make them try again
                System.out.println("Please select valid card");

            }
        }


    }/*currently this is the most simple way for the computer to
    play, could be updated so computer actually has a strategy*/
    public Card computerSelectCardToPlay(){
        handOfCARDS.displayHand();
        int ComputerChoice = 1;
        Card selectedCard = handOfCARDS.playCard(ComputerChoice);
        return selectedCard;
    }
    @Override
    public String toString(){
        String playerOne = (isPlayerOne)? "* is currently Player One" : "(is not Player One)";
        return name + " " + playerOne;
    }

    public abstract void play() ;   //todo override and implement this in HumanPlayer and ComputerPlayer
}
