package Model;

import View.Messages;

import java.util.Scanner;

/**
 * Created by Adrian on 03.05.2017.
 */

// Am creat clasa dealer pentru a separa conditiile pentru optiuni in cazul asilor
    //Dealerul considera asii ca avand un numar de 11 puncte
public class Dealer extends Player {

    public Dealer(Deck deck){
        try {
            drawCardFromDeck(deck);
            drawCardFromDeck(deck);
        }
        // nu ar trebui sa arunce exceptie pe ramura asta niciodata daca pachetul este nou initializat.
        catch (EmptyDeckException e){
            e.printStackTrace();
        }
    }

    public boolean drawCardFromDeck(Deck deck) throws EmptyDeckException{
        int randomCardIndex = (int) Math.floor(Math.random() * deck.getSize()); // trage o carte la intamplare din pachet (indici de la 0 la deck.size)
        Card card = deck.drawCardFromDeck(randomCardIndex);

        if (card.getPoints() + totalPoints <= Constants.WIN) {
            totalPoints += card.getPoints();
            hand.add(card);
            return true;
        }
        else{
            totalPoints += card.getPoints();
            hand.add(card);
            return false; // daca jocul se termina atunci cand trage o carte
        }
    }

}
