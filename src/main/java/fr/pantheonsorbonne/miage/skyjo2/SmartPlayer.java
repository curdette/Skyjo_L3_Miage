package fr.pantheonsorbonne.miage.skyjo2;

public class SmartPlayer extends Player{

    public SmartPlayer(Deck d,Poubelle p){
        super(d, p);
    }

    public void chooseTrashDeck(SkyjoCard card){//card récup de la poubelle sans l'enlever donnée par le plateau
        if (card.getValeur()<=0){
            //lancer une méthode qui joue correctement avec ces cartes
        }
        else if (isSameCard(card) != -1 ){
            if(cardOccurenceColumn(card, mainConnu.get(isSameCard(card))) == 2){
                
            }
            else if (makeColumn(card)){
                makeColumn();
            }
        }
        else if(card.getValeur()<d.getMediane()){
            //lance une méthode pour dans ce cas
        }
        else{
            //d.piocher();
        }

    }

    public void makeColumn(){ 
        SkyjoCard card = p.getLastCard();
        int numColumn= isSameCard(card);
        int num=isEmpty(mainConnu.get(numColumn));
    }

    public boolean makeColumn(SkyjoCard card){
        //plus faire getNbX dans la poubelle pour voire si ça vaut le coup 
        int numColumn =isSameCard(card);
        int occ = cardOccurenceColumn(card, mainConnu.get(numColumn)); 
        if(occ == 1){        // modif : essayer de faire des colonnes en debut de jeu (nb carte connue<7) ensuite seulement si card valeur <5 / 

            return true;
        } 

        return false;
    }

}
