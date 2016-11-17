package com.miked;

import java.util.Collections;
import java.util.InputMismatchException;

public class MainGame {
    final static int MAX_TRICKS = 6;
    int current_trick = 0;

    static UI ui;

    public static void main(String[] args) {
        //use this to allow the use of methods in UI class, mostly scanners
        createUI();

        MainGame game = new MainGame();
        game.play();

        UI.close();
    }
    public static void createUI(){
        ui = new UI();
    }

    //this is used to give players names, and decide if they will be
    //human or computer controlled
    public void setupPlayers(int numberOfPlayers, PlayerManager pm){
        String typeOfPlayer = " Please choose:\n1. Human\n2. Computer";
        String namePrompt = "Please enter the name of the player \n";
        //Run through the setup process as many times as there are players
        for (int i = 0; i<numberOfPlayers; i++) {
            String name = ui.input(namePrompt);
            String type = ui.input(typeOfPlayer);
            if (type.equals("1")) {
                HumanPlayer newPlayer = new HumanPlayer(name);
                pm.add(newPlayer);
            }
            else if (type.equals("2")) {
                ComputerPlayer newPlayer = new ComputerPlayer(name);
                pm.add(newPlayer);
            }else{
                //should use better validation here, will eventually
                System.out.println("Player not added to player list");
                //TODO figure out validation Im too tired to think
            }
        }
    }
    //Getting ready to play the game
    private void play(){

        boolean playAgain = true;
        String anotherRound;
        //use this to create player manager objects, so methods can be used from
        //Player Manager class
        PlayerManager playerManager = new PlayerManager();
        String numOfPlayersPrompt = "How many players? \nMax of 5 players";
        int numOfPlayers = ui.numInput(numOfPlayersPrompt);
        //need to know how many players are playing and playerManager methods
        setupPlayers(numOfPlayers, playerManager);
        //Starts the game and restarts the game if desired
        while(playAgain){
            //deal hands to each player
            playerManager.dealHands();
            //randomly select who will start the game
            Collections.shuffle(playerManager.players);
            //since only the last trick determines the winner of the gane
            //this allows the tricks to be played and a trick winner to be
            //established
            while (current_trick < MAX_TRICKS){
                System.out.println("Trick Number " + (current_trick +1));
                playerManager.oneTrick(current_trick);
                current_trick++;
                playerManager.findWinner();
            }
            //called when the game is complete to determine the winner
            playerManager.printFinalWins();
            //ask user if they want to play again
            anotherRound = ui.input("Play again? n to quit, anything else to continue... ");
            //if anything other than no is selected, play again
            playAgain = !anotherRound.equals("n");
            //reset current trick counter if a new game is started
            if (playAgain){
                current_trick =0;
            }else{
                //when the game is complete thank user for playing
                System.out.println("*-*-*-*-*-Thanks for playing Agram-*-*-*-*-*");
            }
        }
    }
}

