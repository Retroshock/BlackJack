package View;

import Model.Player;



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
        // Aici afisez mana jucatorului
            System.out.println("The player hand: ");
            player.getHand().stream().forEach( x -> System.out.print(x.toString() + " "));
            System.out.println();
    }

    public static void showDealerHand(Player player){
        // Aici afisez mana dealerului
        System.out.println("The dealer hand: ");
        player.getHand().stream().forEach( x -> System.out.print(x.toString() ));
        System.out.println();
    }

    public static void showHiddenDealerHand(Player dealer){
        System.out.println("The dealer hand: ");
        System.out.println(dealer.getHand().get(0) + " " + " { Hidden }");
        System.out.println();
    }

    public static  void showDrawMessage(int points){
        System.out.println("Draw with " + points + " points");
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

    public static void showGameOver(){
        System.out.println("Game Over!");
    }

    public static void showCardDrawn (Player player){
        // Prints out the last card added to the hand
        System.out.print("A " + player.getHand().get(player.getHand().size()-1).toString() + " was drawn from the deck \n \n");
    }

    public static void showAceChoiceQuestion (){
        System.out.println("You have drawn an Ace. How many points do you consider this Ace to be? 1/11");
    }

}
