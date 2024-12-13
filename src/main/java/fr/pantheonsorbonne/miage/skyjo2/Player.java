package fr.pantheonsorbonne.miage.skyjo2;
import java.util.Random;


public abstract class Player {
    Hand main;
    KnownHand knownHand;
    Random rd = new Random();
    Deck d;
    Poubelle poubelle;


    public Player(Deck d,Poubelle p){
        this.d=d;
        this.poubelle=p;
        this.main=new Hand(d);
        this.knownHand=new KnownHand(main,poubelle);
    }

    public void revealCard(int numColumn, int index){
        this.knownHand.get(numColumn)[index]=this.main.getCard(numColumn, index);
    }

    public SkyjoCard replaceCard(int numColumn, int index, SkyjoCard carteRemplacante){
        this.knownHand.get(numColumn)[index]=carteRemplacante;
        return this.main.remplacerCarte(numColumn,index,carteRemplacante);
        
    }

    public void deleteColumn(SkyjoCard card, int numColumn){
        SkyjoCard[] column=knownHand.get(numColumn);
        for (int i=0; i<column.length; i++){
            poubelle.addCard(column[i]);
        }
        knownHand.remove(numColumn);
        main.deleteColumn(numColumn);
        poubelle.addCard(card);
    }

    
    public abstract void chooseKeepOrNot(SkyjoCard card, boolean isFromTrash);

    public void jouer(){
        knownHand.showHand();
        chooseKeepOrNot(poubelle.getLastCard(), true);
        knownHand.showHand();
    }

    

    
}
