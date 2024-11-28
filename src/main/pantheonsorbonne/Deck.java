package pantheonsorbonne;

import java.util.ArrayList;
import java.util.List;
import pantheonsorbonne.Valeur;
import pantheonsorbonne.SkyjoCard.java;

public class Deck {

    private List<SkyjoCard> pioche = new ArrayList<>();
    private static final int nbMoinsDeux = 5;
    private static final int nbZero = 15;
    private static final int nbCarteClassique = 10;

    public Deck(){
        this.pioche=makePioche();
    }

    public List<SkyjoCard> makePioche(){
        List<SkyjoCard> pioche;
        for (Valeur val : Valeur.values()){
            if (val.getValeur()==-2){
                for (int i=0; i<nbMoinsDeux; i++){
                    pioche.add(SkyjoCard(val));
                }
            }
            else if (val.getValeur()==0){
                for (int i=0; i<nbZero; i++){
                    pioche.add(SkyjoCard(val));
                }
            }
            else{
                for (int i=0; i<nbCarteClassique; i++){
                    pioche.add(SkyjoCard(val));
                }
            }
        }
        return pioche;

    }

    public static void main(String[] args){

        Deck d = new Deck ();
    }


}
