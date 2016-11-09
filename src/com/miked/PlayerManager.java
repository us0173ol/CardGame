package com.miked;

import java.util.ArrayList;

/**
 * Created by miked on 11/9/2016.
 */
public class PlayerManager {

    ArrayList<Player> players;

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

}
