package Model;

import java.util.ArrayList;

/**
 * Created by Adrian on 02.05.2017.
 */
public class Deck {

    private ArrayList<Card> pack;
    private int size = 51;

    public Deck() {
        pack = new ArrayList<>();
        fillDeck();
    }

    private void fillDeck(){
        int cardCounter = 1; // Numarul cartii curente.
        for (int i=0; i<52; i++){
            // adding all the cards of number = cardCounter
                CardType type;
                Card tempCard;

                switch (i%4){
                    case 0:{
                        cardCounter++; // Schimb numarul cartii la fiecare set de cate 4 carti de acelasi numar
                        type = CardType.Clubs;
                        break;
                    }
                    case 1:{
                        type = CardType.Spades;
                        break;
                    }
                    case 2:{
                        type = CardType.Diamonds;
                        break;
                    }
                    case 3:{
                        type = CardType.Hearts;
                        break;
                    }
                    default: { // O valoare default pentru compilator.
                        type = CardType.Clubs;
                        break;
                    }
                }

                //Adaugam cartea in pachet
                CardNumber number = makeCardNumberOf(cardCounter); // facem din numarul cartii curente simbolul potrivit
                tempCard = new Card(type, number);
                pack.add(tempCard);
        }
    }

    //Functia returneaza un obiect de tip CardNumber dintr-un int
    private CardNumber makeCardNumberOf(int i) {
        switch (i){
            case 2:{
                return CardNumber.Two;
                
            }
            case 3:{
                return CardNumber.Three;
               
            }
            case 4:{
                return CardNumber.Four;
                
            }
            case 5:{
                return CardNumber.Five;
                
            }
            case 6:{
                return CardNumber.Six;
                
            }
            case 7:{
                return CardNumber.Seven;
                
            }
            case 8:{
                return CardNumber.Eight;
                
            }
            case 9:{
                return CardNumber.Nine;
                
            }
            case 10:{
                return CardNumber.Ten;
                
            }
            case 11:{
                return CardNumber.Ace;
                
            }
            case 12:{
                return CardNumber.J;
                
            }
            case 13:{
                return CardNumber.D;
                
            }
            case 14:{
                return CardNumber.K;
                
            }

        }
        return null;
    }

    // Scoate din pachet cartea cu indicele i
    public Card drawCardFromDeck (int i) throws EmptyDeckException{
        if (size != 0) {
            Card tempCard = pack.get(i);
            pack.remove(i);
            size--;
            return tempCard;
        }
        else{
            throw  new EmptyDeckException();
        }
    }

    public int getSize() {
        return size;
    }
}
