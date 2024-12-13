package fr.pantheonsorbonne.miage.skyjo2;

public class SkyjoCard {

    private Valeur valeur;

    public SkyjoCard(Valeur valeur){
        this.valeur = valeur;
    }

    public int getValeur(){
        return this.valeur.getValeur();
    }

    public String toString(){
        return valeur.toString();
    }

}
