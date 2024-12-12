package fr.pantheonsorbonne.miage.skyjo2;

public class SmartPlayer extends Player{

    public SmartPlayer(Deck d,Poubelle poubelle){
        super(d, poubelle);
    }

    public void chooseKeepOrNotTrash(SkyjoCard card){//card récup de la poubelle donnée par le plateau attention bien l'enlever de la poubelle ou carte piocher
        if (card.getValeur()<=0){
            chooseWhereToReplace(card);
        }
        else if (getColumnIndexSameCard(card) != -1 ){
            int numColumn = getColumnIndexSameCard(card);
            if(cardOccurenceColumn(card,mainConnu.get(numColumn) ) == 2){
                deleteColumn(card, numColumn);
            }
            else{
                tryMakeColumn(card,numColumn);
            }
        }
        else if(card.getValeur()<5){
            chooseWhereToReplace(card);
        }
        else{
            poubelle.addCard(card);
            chooseKeepOrNotDeck(d.piocher());
        }

    }


    public void chooseKeepOrNotDeck(SkyjoCard card){//card piocher / presque meme méthode qu'au dessus => améliorer
        if (card.getValeur()<=0){
            chooseWhereToReplace(card);
        }
        else if (getColumnIndexSameCard(card) != -1 ){
            int numColumn = getColumnIndexSameCard(card);
            if(cardOccurenceColumn(card,mainConnu.get(numColumn) ) == 2){
                deleteColumn(card, numColumn);
            }
            else{
                tryMakeColumn(card,numColumn);
            }
        }
        else if(card.getValeur()<5){
            chooseWhereToReplace(card);
        }
        else{
            poubelle.addCard(card);
            //retourner une nouvelle carte 
        }

    }

    

    public void deleteColumn(SkyjoCard card, int numColumn){
        SkyjoCard[] column=mainConnu.get(numColumn);
        for (int i=0; i<column.length; i++){
            poubelle.addCard(column[i]);
        }
        mainConnu.remove(numColumn);
        main.deleteColumn(numColumn);
        poubelle.addCard(card);
    }

    public void makeColumn(SkyjoCard card ,int numColumn){ 
        SkyjoCard[] column=mainConnu.get(numColumn);
        int[] indexOthersCards=getIndexOtherCard(card,column);
        int bestIndex=chooseBestIndex(indexOthersCards,column);
        if(bestIndex==-1 && column[indexOthersCards[0]].getValeur()<card.getValeur()){
            poubelle.addCard(card);
            chooseKeepOrNotDeck(d.piocher());
        }
        else{
            SkyjoCard cardToDelete=replaceCard(numColumn, bestIndex, card);
            poubelle.addCard(cardToDelete);
        }
    }

    public void tryMakeColumn(SkyjoCard card, int numColumn){
        if (nbKnownCard()>7 ){
            poubelle.addCard(card);
            chooseKeepOrNotDeck(d.piocher());
        }
        else if(card.getValeur()>5){
            poubelle.addCard(card);
            chooseKeepOrNotDeck(d.piocher());
        }
        else{
            makeColumn(card, numColumn);
        }
        
    }

    public int[] getIndexOtherCard(SkyjoCard card, SkyjoCard[] column){
        int[] indexTab=new int[2];
        int index=0;
        for (int i =0; i<column.length;i++){
            if(column[i].equals(card)){
                break;
            }
            indexTab[index]=i;
            index+=1;
        }
        return indexTab;
    } 

    public int chooseBestIndex(int[] index, SkyjoCard[] column){
        SkyjoCard card1 = column[index[0]];
        SkyjoCard card2 = column[index[1]];
        if (card1==null && card2==null){
            return index[0];
        }
        else if(card1==null){
            return index[1];
        }
        else if(card2==null){
            return index[0];
        }
        else if(card2.getValeur() > card1.getValeur()){
            return index[1];
        }
        else if (card1.getValeur()>card2.getValeur()){
            return index[0];
        }
        else{
            return -1; 
        }
    }

    public void replaceHigherCard(SkyjoCard currCard){
        SkyjoCard highCard=null;
        int columnHighCard=0; 
        int indexHighCard=0;
        for (int i=0; i<mainConnu.size();i++){
            SkyjoCard highCardColumn=mainConnu.get(i)[0];
            int tmpIndex=0;
            for(int j=0; j<mainConnu.get(i).length;j++){
                SkyjoCard tmpCard = mainConnu.get(i)[j];
                int occCurrCard=cardOccurenceColumn(currCard, mainConnu.get(i));
                if (occCurrCard==1 && tmpCard.getValeur()>highCardColumn.getValeur()){ // que faire dans le cas ou occ==2
                    highCardColumn=tmpCard;
                    tmpIndex=j;
                }
            }
            if (highCardColumn.getValeur()>highCard.getValeur()){
                highCard=highCardColumn;
                columnHighCard = i;
                indexHighCard=tmpIndex;
            }
        }

        SkyjoCard CardToDelete=replaceCard(columnHighCard, indexHighCard,currCard);
        poubelle.addCard(CardToDelete);
    }

    public int whereEmptyColumn(){
        for (int i =0; i<mainConnu.size(); i++){
            if (nbKnownCard(mainConnu.get(i))==0){
                return i; 
            }
        }
        return -1;
    }

    public void chooseWhereToReplace(SkyjoCard card){
        if (whereEmptyColumn()==-1){
            replaceHigherCard(card);
        }
        else{
            int randomIndex= rd.nextInt(0,mainConnu.get(0).length);
            SkyjoCard CardToDelete=replaceCard(whereEmptyColumn(), randomIndex,card);
            poubelle.addCard(CardToDelete);
        }
    }



}
