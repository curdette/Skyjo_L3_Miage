package fr.pantheonsorbonne.miage.skyjo2;
public class Plateau {
    static SmartPlayer j1;
    static SmartPlayer j2;
    static Deck deck; 
    static Poubelle poubelle;

   

    public Plateau(){
        Plateau.deck=new Deck();
        Plateau.poubelle=new Poubelle(deck);
        Plateau.j1=new SmartPlayer(deck, poubelle); //faire une boucle avec une variable nb de joueur
        Plateau.j2=new SmartPlayer(deck, poubelle);
        
        for (int i=0; i<6 ;i++){
            j1.jouer();
            System.out.println("  ");
            j2.jouer();
        }
        
    }




    public static void main(String[] args){

        Plateau p=new Plateau();
        
    }

}
