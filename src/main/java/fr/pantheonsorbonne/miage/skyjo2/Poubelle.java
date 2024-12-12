package fr.pantheonsorbonne.miage.skyjo2;
import java.util.Deque;
import java.util.LinkedList;

public class Poubelle {
    Deque<SkyjoCard> poubelle;
     
    public Poubelle(Deck d){
        this.poubelle=new LinkedList<SkyjoCard>();
        poubelle.push(d.piocher());
    }

    public SkyjoCard getLastCard(){
        return poubelle.pop();
    }

    public SkyjoCard seeLastCard(){
        return poubelle.peek();
    }

    public void ajouterCarte(SkyjoCard carte){
        poubelle.push(carte);
    }

}
