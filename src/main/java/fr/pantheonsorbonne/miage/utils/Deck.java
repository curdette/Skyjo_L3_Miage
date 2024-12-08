package fr.pantheonsorbonne.miage.utils;

import java.util.ArrayList;
import java.util.List;
import fr.pantheonsorbonne.miage.utils.SkyjoCard;
import fr.pantheonsorbonne.miage.utils.Valeur;


public class Deck {

    private List<SkyjoCard> pioche;
    private static final int nbMoinsDeux = 5;
    private static final int nbZero = 15;
    private static final int nbCarteClassique = 10;

    public Deck(){
        this.pioche=makePioche();
    }

    public List<SkyjoCard> makePioche(){
        List<SkyjoCard> pioche = new ArrayList<>();
        for (Valeur val : Valeur.values()){
            if (val.getValeur()==-2){
                for (int i=0; i<nbMoinsDeux; i++){
                    pioche.add(new SkyjoCard(val));
                }
            }
            else if (val.getValeur()==0){
                for (int i=0; i<nbZero; i++){
                    pioche.add(new SkyjoCard(val));
                }
            }
            else{
                for (int i=0; i<nbCarteClassique; i++){
                    pioche.add(new SkyjoCard(val));
                }
            }
        }
        return pioche;

    }

    public static void main(String[] args){

        Deck d = new Deck ();
        System.out.println("Deck created with " + d.pioche.size() + " cards.");
    }


}
