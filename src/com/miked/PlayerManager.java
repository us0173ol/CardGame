package com.miked;

import java.util.ArrayList;

/**
 * Created by miked on 11/9/2016.
 */
public class PlayerManager {

    //global variables to hold objects in lists
    ArrayList<Player> players;
    ArrayList<Card> cardsPlayedThisRound;
    //new deck created
    Deck deck = new Deck();
    //rules of the game only allow for 5 players maximum
    public final int MAX_PLAYERS = 5;

    public PlayerManager(ArrayList<Player> players){
        this.players= players;
        //Validation for only allowing 5 or less players to play the game
        while(players.size() > MAX_PLAYERS){
            System.out.println("More than 5 players, removing players from the end of the list");
            System.out.println(players.remove(MAX_PLAYERS+1).getName());

        }
    }
    public PlayerManager(){
        this.players = new ArrayList<Player>();
        this.cardsPlayedThisRound = new ArrayList<>();

    }
    //method for each trick
    public void oneTrick(int currentTrick){
        players.get(0).setPlayerOne(true);
        /*checks if player is human or computer and if they are the first
        to play in the trick(which sets the card played suit) adds the card
        to the list for the trick and displays each card played, who played
        it, and the trick as a whole*/
        for (Player p : players){
            if (p.isPlayerOne && p instanceof HumanPlayer){
                Card playedCard = p.humanSelectCardToPlay();
                playedCard.setAlpha(true);
                cardsPlayedThisRound.add(playedCard);
                System.out.println(p.getName() + " played: "+ cardsPlayedThisRound.get(0));
                System.out.println("Current Trick"+cardsPlayedThisRound);
            }
            if (!p.isPlayerOne && p instanceof HumanPlayer){
                Card playedCard = p.humanSelectCardToPlay();
                cardsPlayedThisRound.add(playedCard);
                System.out.println(p.getName() + " played: " + cardsPlayedThisRound.get(cardsPlayedThisRound.size()-1)+ "\n");
                System.out.println("Current Trick"+cardsPlayedThisRound);
            }
            if (p.isPlayerOne && p instanceof ComputerPlayer){
                Card playedCard = p.computerSelectCardToPlay();
                playedCard.setAlpha(true);
                cardsPlayedThisRound.add(playedCard);
                System.out.println(p.getName() + " played: " + cardsPlayedThisRound.get(cardsPlayedThisRound.size()-1)+ "\n");
                System.out.println("Current Trick"+cardsPlayedThisRound);
            }
            if (!p.isPlayerOne && p instanceof ComputerPlayer){
                Card playedCard = p.computerSelectCardToPlay();
                cardsPlayedThisRound.add(playedCard);
                System.out.println(p.getName() + " played: " + cardsPlayedThisRound.get(cardsPlayedThisRound.size()-1)+ "\n");
                System.out.println("Current Trick"+cardsPlayedThisRound);
            }
            else{
                System.out.println("");
            }
        }

        //figure out who won this trick

        Player trickwinner = figureOutWinner();
        //called method to make the trick winner play first in the next trick
        rearrangePlayers(trickwinner);

        deck.cards.addAll(cardsPlayedThisRound);
        cardsPlayedThisRound.clear();
        //in Agram the only trick that matters is the last one
        if (currentTrick == 5){
            trickwinner.setWins(1);
        }
    }

    private void rearrangePlayers(Player trickWinner) {
        players.remove(trickWinner);
        //move whoever won to the start of the Player players arraylist
        players.add(0, trickWinner);
        //set all players to NOT player one...
        for(Player p : players){
            p.setPlayerOne(false);
        }//then get the trickwinner and set them to player one
        players.get(0).setPlayerOne(true);

    }
    //compares the values of the cards that match the suit of the
    //first card played
    public Player figureOutWinner() {
        int counter = 0;
        Card firstPlayed = cardsPlayedThisRound.remove(0);
        int maxScore = firstPlayed.getValue();
        Player winner = players.get(0);

        for(Card c: cardsPlayedThisRound){

            counter++;
            //compares suit of cardplayed to suit of first card played
            if (c.getSuit() == firstPlayed.getSuit() ){
                //then get the value of that card
                if (c.getValue() > maxScore){
                    //since maxscore is set to the value of the first
                    //card, if the value of the new card is higher, that
                    //card(value) is now the maxscore
                    maxScore = c.getValue();
                    //use the counter to correlate the card compared to
                    //the player that played it
                    winner = players.get(counter);


                }
            }
        }

        winner.setCurrentScore(maxScore);
        cardsPlayedThisRound.add(firstPlayed);
        printTrickWinner(winner);
        return winner;
        //what was suit of first card in cardsPlayedThisRound
        //what is the card with the highest value of that suit - what position is it in the cardsPlayedThisRound arraylist?
        //if (e.g.) card 2 in the cardsPlayedThisRound is the winner,
        //then player at element 2 in the players ArrayList is the winner
    }
    //method to add players to the game(list of players) as long as
    //there arent more than can play
    public void add(Player player){
        if (players.size()< MAX_PLAYERS){
            players.add(player);
        }else {
            MainGame.ui.output("There's already "+MAX_PLAYERS+" in the game.  Can't add "+player.getName());

        }
    }
    public ArrayList<Player> getPlayersList(){
        return players;
    }
    //basic dealing method, could be altered to deal three at a time
    public void dealHands(){
        for (int i = 0; i < 6; i++){
            for(Player p : players){
                Card dealtCard = deck.deal();
                p.handOfCARDS.addCard(dealtCard);
            }
        }
    }

    public void printFinalWins(){
        //since the last trick winner is moved to the first player
        System.out.println( players.get(0).getName()+ " wins the GAME!");
    }//print game winner
    public void printTrickWinner(Player trickWinner){
        System.out.println(trickWinner.getName()+ " wins the TRICK!");
    }

    public Player findWinner() {

        //todo you have a list of players, you can get the cardPlayedThisRound variable, so you can figure out who won.
        return null; //replace with return statement to return the winner
    }
}
