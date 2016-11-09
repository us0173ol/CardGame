package com.miked;

public class MainGame {

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
    private void play(){

        PlayerManager playerManager = new PlayerManager();

        HumanPlayer me = new HumanPlayer("Me");
        HumanPlayer you = new HumanPlayer("You");

        playerManager.add(me);
        playerManager.add(you);

        boolean playAgain = true;
        String anotherRound;

        while(playAgain){
            Round round = new Round(playerManager);
            round.play();

            anotherRound = ui.input("Play again? n to quit, anything else to continue... ");

            playAgain = !anotherRound.equals("n");


        }

    }



//        Deck officialDeck = new Deck();
//
//
//        officialDeck.showDeck();




}

