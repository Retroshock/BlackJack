package Controller;

import Model.*;
import View.Messages;

import java.util.Scanner;

/**
 * Created by Adrian on 02.05.2017.
 */
public class GameController {


    private Scanner sc = new Scanner(System.in);
    private Deck deck;
    private Player player;
    private Dealer dealer;

    public GameController(){

        // mesaj de inceput
        Messages.showBeginningMessage();

        //initializez pachetul
        deck = new Deck();

        //Dealerul trage 2 carti
        dealer = new Dealer(deck);

        //Jucatorul trage 2 carti
        player = new Player(deck);

        // se afiseaza mana dealerului
        Messages.showHiddenDealerHand(dealer);

        // se afiseaza mana jucatorului
        Messages.showPlayerHand(player);

        // Se porneste loop-ul, se incepe jocul
        while (true){
            if (player.getTotalPoints() == Constants.WIN){
                if (checkDraw(player, dealer)){
                    // Afiseaza mesaj de remiza
                    Messages.showDrawMessage(player.getTotalPoints());
                    break;
                }
                // Afiseaza mesaj de castig
                Messages.showWinningMessage(player);
                break;
            }

            // afisez mesaj de intrebare (Do you want to draw another card?)



            Messages.showContinueToDrawQuestion();
            String result = new String();
            result = sc.next();


            result.toLowerCase();
            if ("y".equals(result))
                try {
                    //verific daca poate trage inca o carte
                    if (!player.drawCardFromDeck(deck)){
                        Messages.showCardDrawn(player);
                        Messages.showLosingMessage(player.getTotalPoints(), dealer.getTotalPoints());
                        break;
                    }
                    else{
                        Messages.showCardDrawn(player);
                    }
                }
                catch (EmptyDeckException e){
                    // afiseaza mesaj de pachet gol.
                    Messages.showEmptyPackMessage();
                }
            else
                if ("n".equals(result)) {
                    // afiseaza cartile ascunse ale dealerului, verifica totalul punctelor si opreste jocul

                    Messages.showDealerHand(dealer);

                    //Dealerul ia carti din pachet cat timp mana sa are mai putin de 17 puncte
                    while (dealer.getTotalPoints() < 17 ){
                        try {
                            if (!dealer.drawCardFromDeck(deck)){
                                Messages.showCardDrawn(dealer);
                                Messages.showWinningMessage(player);
                                break;
                            }
                            else{
                                //afisez cartea trasa din pachet
                                Messages.showCardDrawn(dealer);
                            }
                            Messages.showDealerHand(dealer);
                        }catch (EmptyDeckException e){
                            Messages.showEmptyPackMessage();
                        }
                    }
                    //verifica daca dealerul are mai mult de 21 de puncte
                    if (dealer.getTotalPoints() > 21)
                        break;

                    if (checkWin(player, dealer) == true ){
                        // Afiseaza mesaj de castig
                        Messages.showWinningMessage(player);
                        break;
                    }
                    else{
                        if (checkDraw(player, dealer)) {
                            // Afiseaza mesaj de draw
                            Messages.showDrawMessage(player.getTotalPoints());
                        }
                        else{
                            // Afiseaza mesaj de pierdut
                            Messages.showLosingMessage(player.getTotalPoints(), dealer.getTotalPoints());
                        }
                        break;
                    }

                }

        }

        Messages.showGameOver();
        sc.close();
    }

    private boolean checkWin(Player player, Player dealer) {
        if (player.getTotalPoints() > dealer.getTotalPoints() && player.getTotalPoints() < Constants.WIN)
            return true;
        else
            return false;
    }

    private boolean checkDraw(Player player, Player dealer){
        if (player.getTotalPoints() == dealer.getTotalPoints())
            return true;
        else
            return false;
    }

}
