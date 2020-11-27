package model;

/**
* Exception class, throw DicePokerIllegalDataException is specific cases
*
* @author Jakub Zaremba
* @version 2.0
* @since   2020-11-14
*/
public class DicePokerIllegalDataException extends RuntimeException {
    /**
     * Constructor that run construction of RuntimeException with defined message
     * @param message information that we want to display 
     */
    public DicePokerIllegalDataException(String message){
        super(message);
    }
}
