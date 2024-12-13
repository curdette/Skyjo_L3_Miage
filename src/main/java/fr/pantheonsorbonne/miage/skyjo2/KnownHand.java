package fr.pantheonsorbonne.miage.skyjo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KnownHand {
    List<SkyjoCard[]> knownHand=new ArrayList<>();
    Random rd = new Random();
    Hand hand;

    
    public KnownHand(Hand hand, Poubelle poubelle){
        this.hand=hand;
        this.knownHand=initialiserMainConnu(hand);
        
    }

    private List<SkyjoCard[]> initialiserMainConnu(Hand hand) {
        List<SkyjoCard[]> knownHand = new ArrayList<>();
        for (int i=0; i<4;i++){
            SkyjoCard[] column=new SkyjoCard[3];
            knownHand.add(i,column);
        }
        do{
            int i= rd.nextInt(0,knownHand.size());
            int j= rd.nextInt(0,knownHand.get(0).length);
            knownHand.get(i)[j]=this.hand.getCard(i, j);
        }while( nbKnownCard() != 2);
        return knownHand; 
    }

    public int nbKnownCard(){
        int nb=0;
        for (SkyjoCard[] column : knownHand){
            nb+=nbKnownCard(column);
        }
        return nb;
    }

    public int nbKnownCard(SkyjoCard[] column){
        int nb=0;
        for (SkyjoCard card : column){
            if (card != null){
                nb+=1;
            }
        }
        return nb;
    }

    public SkyjoCard[] get(int numColumn) {
        return knownHand.get(numColumn);
    }

    public int size(){
        return knownHand.size();
    }

    public void remove(int numColumn){
        knownHand.remove(numColumn);
    }

    public void showHand(){
        for(int j=0; j<knownHand.get(0).length;j++){
            for (int i=0; i<knownHand.size();i++){
                System.out.print(knownHand.get(i)[j]+"           ");
            }
            System.out.println("");

        }
    }

    public int getIndexColumnSameCard(SkyjoCard card){
        int maxNb=0;
        int numColumnMax=-1;
        for (int i =0; i<knownHand.size();i++){
            int nbCard = cardOccurenceColumn(card, knownHand.get(i));
            if (nbCard>maxNb){
                numColumnMax= i;
            }
        }
        return numColumnMax;
    }

    public int cardOccurenceColumn(SkyjoCard card, SkyjoCard[] column){
        int nbSameCard=0;
        for (SkyjoCard c : column){
            if (c==null){
                break;
            }
            else if(c.getValeur()==card.getValeur()){
                nbSameCard+=1;
            }
        }
        return nbSameCard;
    }

    
}
