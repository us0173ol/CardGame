package com.miked;

/**
 * todo finish this
 *
 */
public class ComputerPlayer extends Player {

    
    public ComputerPlayer(String name ) {
        super(name);
        this.handOfCARDS.setOwner(this.name);
    }

    @Override
    public void play() {

        if (handOfCARDS != null){
            handOfCARDS.displayHand();

            }
        }

    }

