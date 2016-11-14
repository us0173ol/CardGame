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

    public void oneTrick(){
        players.get(0).setPlayerOne(true);

        for (Player p : players){
            if (p.isPlayerOne && p instanceof HumanPlayer){
                Card playedCard = p.humanSelectCardToPlay();
                playedCard.setAlpha(true);
                cardsPlayedThisRound.add(playedCard);
            }
            if (!p.isPlayerOne && p instanceof HumanPlayer){
                System.out.println("Player one played: " + cardsPlayedThisRound.get(0)+ "\n");
                Card playedCard = p.humanSelectCardToPlay();
                cardsPlayedThisRound.add(playedCard);
            }else{
                System.out.println("Computers turn...");
            }
        }

        //figure out who won this trick

        figureOutWinner();

        rearrangePlayers();


    }

    int winningPlayerIndex = 0;

    private void rearrangePlayers() {

        //move whoever won to the start of the Player players arraylist

        Player winner = players.remove(winningPlayerIndex);
        players.add(0, winner);

    }

    private void figureOutWinner() {

        //what was suit of first card in cardsPlayedThisRound
        //what is the card with the highest value of that suit - what position is it in the cardsPlayedThisRound arraylist?
        //if (e.g.) card 2 in the cardsPlayedThisRound is the winner,
        //then player at element 2 in the players ArrayList is the winner

        winningPlayerIndex = 3;  //figure this out

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
        System.out.println("TODO printFinalWins");
    }
}
