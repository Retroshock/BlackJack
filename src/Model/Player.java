package Model;

import View.Messages;
import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultXMLDocumentHandler;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Adrian on 02.05.2017.
 */
public class Player {
    protected ArrayList<Card> hand = new ArrayList<>();
    protected int totalPoints = 0;

    public Player(){}

    public Player(Player player){
        this.hand = player.getHand();
        this.totalPoints = player.getTotalPoints();
    }

    // Prima data cand instantiez jucatorul acesta va avea 2 carti la intamplare in mana.
    public Player(Deck deck){
        try {
            drawCardFromDeck(deck); // se afiseaza cartile pentru a putea alege in cazul in care jucatorul primeste un as
            Messages.showCardDrawn(this);
            drawCardFromDeck(deck);
            Messages.showCardDrawn(this);
        }
        // nu ar trebui sa arunce exceptie pe ramura asta niciodata daca pachetul este nou initializat.
        catch (EmptyDeckException e){
            e.printStackTrace();
        }
    }

    public boolean drawCardFromDeck(Deck deck) throws EmptyDeckException{
        int randomCardIndex = (int) Math.floor(Math.random() * deck.getSize()); // trage o carte la intamplare din pachet (indici de la 0 la deck.size)
        Card card = deck.drawCardFromDeck(randomCardIndex);

        // ofer posibilitatea de a selecta ce valoare sa aiba cartea extrasa
        // daca valoarea e diferita de 1 sau 11 se pun automat 11 puncte pentru acel as
        if (card.getNumber() == CardNumber.Ace){
            Messages.showAceChoiceQuestion();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            Card newCard;
            if (choice == 1){
                newCard = new Card(card.getType(), card.getNumber(), choice);
                card = newCard;
            }
        }
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

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
