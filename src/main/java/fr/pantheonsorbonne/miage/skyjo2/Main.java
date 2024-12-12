package fr.pantheonsorbonne.miage.skyjo2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<SkyjoCard[]> main=new ArrayList<>();

    public Main(Deck d){
        this.main=faireMain(d);
    }

    private List<SkyjoCard[]> faireMain(Deck d){
        List<SkyjoCard[]> main = new ArrayList<>();
        for (int i=0; i<4;i++){
            SkyjoCard[] colonne=new SkyjoCard[3];
            for(int j=0; j<3; j++){
                colonne[j]=d.piocher();
            }
        main.add(i,colonne);
        }
        return main; 
    }

    public SkyjoCard getCard(int i, int j){ 
        return main.get(i)[j]; 
    }

    public void deleteColumn(int i){
        main.remove(i);
    }

    public SkyjoCard remplacerCarte(int i, int j, SkyjoCard carteRemplacante){
        SkyjoCard carteAJeter =this.main.get(i)[j];
        this.main.get(i)[j]=carteRemplacante;
        return carteAJeter;
    }





}
