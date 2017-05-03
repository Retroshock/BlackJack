package Controller;

import Model.*;

import java.util.Scanner;

/**
 * Created by Adrian on 02.05.2017.
 */
public class GameController {

    private Deck deck;
    private Player player;
    private Dealer dealer;

    GameController(){

        //TODO mesaje de inceput
        //initializez pachetul
        deck = new Deck();

        //Dealerul trage 2 carti
        dealer = new Dealer(deck);

        //Jucatorul trage 2 carti
        player = new Player(deck);

        //TODO se afiseaza mana dealerului

        //TODO se afiseaza mana jucatorului

        // Se porneste loop-ul, se incepe jocul
        while (true){
            if (player.getTotalPoints() == Constants.WIN){
                if (dealer.getTotalPoints() == Constants.WIN){
                    //TODO Afiseaza mesaj de remiza
                }
                //TODO Afiseaza mesaj de castig

                break;
            }
            //TODO afisez mesaj de intrebare (Do you want to draw another card?)
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
                    }
                else {
                    //TODO afiseaza cartile, verifica totalul punctelor si opreste jocul
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
