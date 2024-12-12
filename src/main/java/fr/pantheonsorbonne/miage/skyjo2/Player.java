package fr.pantheonsorbonne.miage.skyjo2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public abstract class Player {
    Hand main;
    List<SkyjoCard[]> mainConnu=new ArrayList<>();
    Random rd = new Random();
    Deck d;
    Poubelle poubelle;


    public Player(Deck d,Poubelle p){
        this.d=d;
        this.poubelle=p;
        this.main=new Hand(d);
        this.mainConnu=initialiserMainConnu();
    }

        
    private List<SkyjoCard[]> initialiserMainConnu() {
        List<SkyjoCard[]> mainConnu = new ArrayList<>();
        for (int i=0; i<4;i++){
            SkyjoCard[] column=new SkyjoCard[3];
            mainConnu.add(i,column);
        }
        for (int k=0;k<2;k++){
            int i= rd.nextInt(0,mainConnu.size());
            int j= rd.nextInt(0,mainConnu.get(0).length);
            mainConnu.get(i)[j]=this.main.getCard(i, j);
        }
        return mainConnu; 
    }

    public int nbKnownCard(){
        int nb=0;
        for (SkyjoCard[] column : mainConnu){
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
    
    
    public void showCard(int numColumn, int index){
        this.mainConnu.get(numColumn)[index]=this.main.getCard(numColumn, index);
    }

    public SkyjoCard replaceCard(int numColumn, int index, SkyjoCard carteRemplacante){
        this.mainConnu.get(numColumn)[index]=carteRemplacante;
        return this.main.remplacerCarte(numColumn,index,carteRemplacante);
        
    }

    public int getColumnIndexSameCard(SkyjoCard card){
        int maxNb=0;
        int numColumnMax=-1;
        for (int i =0; i<mainConnu.size();i++){
            int nbCard = cardOccurenceColumn(card, mainConnu.get(i));
            if (nbCard>maxNb){
                numColumnMax= i;
            }
        }
        return numColumnMax;
    }

    public int cardOccurenceColumn(SkyjoCard card, SkyjoCard[] column){
        int nbSameCard=0;
        for (SkyjoCard c : column){
            if(c.getValeur()==card.getValeur()){
                nbSameCard+=1;
            }
        }
        return nbSameCard;
    }

    
}
