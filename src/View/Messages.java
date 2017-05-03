package View;

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

}
