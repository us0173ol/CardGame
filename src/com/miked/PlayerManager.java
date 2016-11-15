package com.miked;

import java.util.ArrayList;

/**
 * Created by miked on 11/9/2016.
 */
public class PlayerManager {


    ArrayList<Player> players;
    ArrayList<Card> cardsPlayedThisRound;

    Deck deck = new Deck();

    public final int MAX_PLAYERS = 5;

    public PlayerManager(ArrayList<Player> players){
        this.players= players;

        while(players.size() > MAX_PLAYERS){
            System.out.println("More than 5 players, removing players from the end of the list");
            System.out.println(players.remove(MAX_PLAYERS+1).getName());

        }
    }
    public PlayerManager(){
        this.players = new ArrayList<Player>();
        this.cardsPlayedThisRound = new ArrayList<>();

    }

    public void oneTrick(int currentTrick){
        players.get(0).setPlayerOne(true);

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
            }else{
                System.out.println("");
            }
        }

        //figure out who won this trick

        Player trickwinner = figureOutWinner();

        rearrangePlayers(trickwinner);

        deck.cards.addAll(cardsPlayedThisRound);
        cardsPlayedThisRound.clear();
        if (currentTrick == 5){
            trickwinner.setWins(1);
        }


    }

    int winningPlayerIndex = 0;

    private void rearrangePlayers(Player trickWinner) {
        players.remove(trickWinner);
        //move whoever won to the start of the Player players arraylist
        players.add(0, trickWinner);

        for(Player p : players){
            p.setPlayerOne(false);
        }
        players.get(0).setPlayerOne(true);

    }

    public Player figureOutWinner() {
        int counter = 0;
        Card firstPlayed = cardsPlayedThisRound.remove(0);
        int maxScore = firstPlayed.getValue();
        Player winner = players.get(0);

        for(Card c: cardsPlayedThisRound){

            counter++;
            if (c.getSuit() == firstPlayed.getSuit() ){
                if (c.getValue() > maxScore){

                    maxScore = c.getValue();
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

    public void dealHands(){
        for (int i = 0; i < 6; i++){
            for(Player p : players){
                Card dealtCard = deck.deal();
                p.handOfCARDS.addCard(dealtCard);
            }
        }
    }

    public Player findWinner() {

        //todo you have a list of players, you can get the cardPlayedThisRound variable, so you can figure out who won.
        return null; //replace with return statement to return the winner
    }
    public void printFinalWins(){
        System.out.println( players.get(0).getName()+ " wins the GAME!");
    }
    public void printTrickWinner(Player trickWinner){
        System.out.println(trickWinner.getName()+ " wins the TRICK!");
    }
}
