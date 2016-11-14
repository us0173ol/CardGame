package com.miked;

import java.util.Collections;

public class MainGame {

    final static int MAX_TRICKS = 6;
    int current_trick = 0;

    static UI ui;

    public static void main(String[] args) {

        createUI();

        MainGame game = new MainGame();
        game.play();

        UI.close();
    }
    public static void createUI(){
        ui = new UI();
    }

    public void setupPlayers(int numberOfPlayers, PlayerManager pm){

        String namePrompt = "Please enter the name of the player \n";
        for (int i = 0; i<numberOfPlayers; i++){
            String name = ui.input(namePrompt);
            HumanPlayer newPlayer = new HumanPlayer(name);
            pm.add(newPlayer);
        }
    }

    private void play(){

//        PlayerManager playerManager = new PlayerManager();
//
//        HumanPlayer me = new HumanPlayer("Me");
//        HumanPlayer you = new HumanPlayer("You");
//
//        //todo PlayerManager deals with Players. So you could add a ComputerPlayer object instead of, or as well as, the human players.
//
//        playerManager.add(me);
//        playerManager.add(you);

        boolean playAgain = true;
        String anotherRound;
        PlayerManager playerManager = new PlayerManager();
        String numOfPlayersPrompt = "How many players? \nMax of 5 players";
        int numOfPlayers = ui.numInput(numOfPlayersPrompt);
        setupPlayers(numOfPlayers, playerManager);

        while(playAgain){

            playerManager.dealHands();
//            round.play();
            Collections.shuffle(playerManager.players);
            while (current_trick < 6){
                System.out.println("Trick Number");
                playerManager.oneTrick();
                current_trick++;
                playerManager.findWinner();
            }

            anotherRound = ui.input("Play again? n to quit, anything else to continue... ");

            playAgain = !anotherRound.equals("n");

            if (playAgain){
                current_trick =0;
            }


        }
        playerManager.printFinalWins();

    }



//        Deck officialDeck = new Deck();
//
//
//        officialDeck.showDeck();




}

