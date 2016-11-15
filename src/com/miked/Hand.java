package com.miked;

import java.util.ArrayList;

/**
 * Created by miked on 11/8/2016.
 */
public class Hand {
    String owner;

    ArrayList<Card> handOfCards;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setHandOfCards(ArrayList<Card> handOfCards) {
        this.handOfCards = handOfCards;
    }

    public Hand(){
        this.owner = "";
        this.handOfCards = new ArrayList<Card>();


    }

    public void addCard(Card newCard){
        if(this.handOfCards.size() < 6 ){
            handOfCards.add(newCard);
        }else{
            System.out.println("Only six cards per hand");
        }
    }
    public Card playCard(int cardNumber){
        return handOfCards.remove(cardNumber -1);

//        for(int i = 0; i<handOfCards.size(); i++){
//            System.out.println(i + ") " + handOfCards.get(i));
//
//        }
//        System.out.println("Please choose a card to play.");
//        String choice = MainGame.ui.input();
//        int chosen = (Integer.parseInt(choice));
//        Card played = handOfCards.remove(chosen);
//
//        return played;
    }

    public ArrayList<Card> getHandOfCards(){
        return handOfCards;
    }

    public int size(){
        return handOfCards.size();
    }

    public String toString(){
        String cards = "";
        for(Card c:handOfCards){
            cards = cards + c.toString() + " ";
        }
        return cards;
    }

    public void displayHand(){
        System.out.println("*****"+this.owner+"'s Hand*****");
        for(int i = 0; i < handOfCards.size(); i++){
            System.out.println((i+1)+") " +handOfCards.get(i));
        }
    }
}
