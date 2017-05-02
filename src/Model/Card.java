package Model;

/**
 * Created by Adrian on 02.05.2017.
 */
public class Card {
    // Clasa Card imi tine o singura carte de joc cu toate informatiile despre ea
    // incluzand metode de get/set
    private CardType type;
    private CardNumber number;
    private int points;


    // Constructor cu 2 parametrii care seteaza automat punctele pentru cartea primita
    public Card(CardType type, CardNumber number) {
        this.type = type;
        this.number = number;
        setPoints(this.number);
    }

    //functie care seteaza automat punctele pentru o valoare a unei carti.
    private void setPoints(CardNumber number) {
        if (number.getNumber() <= 10){
            points = number.getNumber();
        }
        else{
            if (number.getNumber() == 11)
                points = 11;
            else
                points = 10;
        }
    }

    @Override
    public String toString() {
        return "Card{ " +
                 number.toString() +
                " of " + type.toString() +
                " }" + "\n";
    }

    public int getPoints() {
        return points;
    }
}
