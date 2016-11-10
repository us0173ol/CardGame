package com.miked;

/**
 * Created by miked on 11/8/2016.
 */
public abstract class Player {

    String name;
    Hand handOfCARDS;

    Card cardPlayedThisRound;


    Player(String name){
        this.name = name;

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

    public abstract void play() ;   //todo override and implement this in HumanPlayer and ComputerPlayer
}
