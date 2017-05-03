package View;

import Model.Dealer;
import Model.Player;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by Adrian on 02.05.2017.
 */
public class Messages {

    //afiseaza ca ai pierdut si punctele pe care le-ai avut tu si dealerul
    public static void showLosingMessage (int playerPoints, int dealerPoints){
        System.out.println("You have lost!");
        System.out.println("The Dealer had " + dealerPoints + " points.");
        System.out.println("The Player had " + playerPoints + " points.");

    }
    public static void showPlayAgainMessage(){
        System.out.println("Play Again? Y/N");
    }

    public static void showBeginningMessage(){
        System.out.println("Welcome! Let the game begin. \n Initial draw.");
    }


    public static void showPlayerHand(Player player){
        // Aici ma folosesc de clasa dealer propriu-zis
        if (player instanceof Dealer) {
            System.out.println("The dealer hand: ");
            System.out.print(player.getHand().get(0).toString() + ' ' + "{ Hidden }");
            System.out.println();
        }
        else {
            System.out.println("The player hand: ");
            System.out.print(player.getHand().get(0).toString() + ' ' + player.getHand().get(1));
            System.out.println();
        }
    }

    public static  void showDrawMessage(){
        System.out.println("Draw!");
    }

    public static void showWinningMessage(Player player){
        System.out.println("Player wins with the hand: " + player.getHand().toString()
        );
    }
    public static void showContinueToDrawQuestion(){
        System.out.println("Do you want to draw another card? Y/N");
    }

    public static void showEmptyPackMessage(){
        // Nu ar trebui sa se ajunga aici din moment ce este un singur utilizator, dar am adaugat-o in cazul in care se scaleaza aplicatia
        System.out.println("The pack is empty!");
    }

}
