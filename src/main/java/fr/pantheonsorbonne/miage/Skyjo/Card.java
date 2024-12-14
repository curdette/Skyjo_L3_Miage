package fr.pantheonsorbonne.miage.Skyjo;

public class Card {
    private final Value cardName;

    public Card(final Value cardName){
        this.cardName = cardName;
    }    


public Value getCardName(){
    return this.cardName;
}

public Card[] getAllPossibleCards(){
    Card[] allPossibleCards = new Card[150];
    for(int i =0; i<150; i++){
        for(Value cardName : Value.values()){
            
        }
    }
}
}