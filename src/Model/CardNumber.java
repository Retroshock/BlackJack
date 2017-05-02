package Model;

/**
 * Created by Adrian on 02.05.2017.
 */
public enum CardNumber {
    //Aici creez numarul cartii cu posibilitate de a fi adaugat cu numarul direct
    Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8),
    Nine(9), Ten(10), Ace(11), J(12), D(13), K(14);
    private int number;

    CardNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }


}
