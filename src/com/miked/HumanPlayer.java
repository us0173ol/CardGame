package com.miked;

import java.util.ArrayList;

/**
 * Created by miked on 11/8/2016.
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String name){
        super(name);
        this.handOfCARDS.setOwner(this.name);
    }

    @Override
    public void play() {
    }
}
