package Model;

import View.Messages;
import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultXMLDocumentHandler;

import java.util.ArrayList;

/**
 * Created by Adrian on 02.05.2017.
 */
public class Player {
    private ArrayList<Card> hand = new ArrayList<>();
    private int totalPoints = 0;

    // Prima data cand instantiez jucatorul acesta va avea 2 carti la intamplare in mana.
    public Player(Deck deck){
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
            return false; // daca jocul se termina atunci cand trage o carte
        }
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
