package Controller;

import Model.*;
import View.Messages;

import java.util.Scanner;

/**
 * Created by Adrian on 02.05.2017.
 */
public class GameController {

    public static void main(String[] args) {
        GameController gc = new GameController();
    }

    private Deck deck;
    private Player player;
    private Dealer dealer;

    GameController(){

        //TODO mesaje de inceput
        Messages.showBeginningMessage();

        //initializez pachetul
        deck = new Deck();

        //Dealerul trage 2 carti
        dealer = new Dealer(deck);

        //Jucatorul trage 2 carti
        player = new Player(deck);

        //TODO se afiseaza mana dealerului
        Messages.showPlayerHand(dealer);

        //TODO se afiseaza mana jucatorului
        Messages.showPlayerHand(player);

        // Se porneste loop-ul, se incepe jocul
        while (true){
            if (player.getTotalPoints() == Constants.WIN){
                if (dealer.getTotalPoints() == Constants.WIN){
                    //TODO Afiseaza mesaj de remiza
                    Messages.showDrawMessage();
                }
                //TODO Afiseaza mesaj de castig
                Messages.showWinningMessage(player);
                break;
            }
            //TODO afisez mesaj de intrebare (Do you want to draw another card?)
            Messages.showContinueToDrawQuestion();
            Scanner sc = new Scanner(System.in);
            if (sc.hasNext()){
                String result = sc.next();
                result.toLowerCase();
                if ("y".equals(result))
                    try {
                        player.drawCardFromDeck(deck);
                    }
                    catch (EmptyDeckException e){
                        //TODO afiseaza mesaj de pachet gol.
                        |Messages.showEmptyPackMessage();
                    }
                else {
                    //TODO afiseaza cartile ascunse ale dealerului, verifica totalul punctelor si opreste jocul
                    //transform in tempPlayer dealerul in jucator normal ca sa imi afiseze si cartile lui.
                    Player tempPlayer = (Player) dealer;
                    Messages.showPlayerHand(dealer);
                    while ()
                    if (checkWin(player, dealer) == true){
                        //TODO Afiseaza mesaj de castig
                        break;
                    }
                    else{
                        //TODO Afiseaza mesaj de pierdut
                        break;
                    }

                }
            }


        }

    }

    private boolean checkWin(Player player, Dealer dealer) {
        if (player.getTotalPoints() > dealer.getTotalPoints())
            return true;
        else
            return false;
    }

}
