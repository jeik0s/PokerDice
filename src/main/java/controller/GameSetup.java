package controller;

import java.util.Scanner;
import model.DicePoker;
import view.View;

/**
* Main controller class responsible for controlling data flow between model and view
*
* @author Jakub Zaremba
* @version 1.0
* @since   2020-11-01 
*/
public class GameSetup {
    /**
     * Function allows user to put number of dice polls
     * @return number of dices polls
     */
    private int[] getDicePolls(){
        int[] dicePolls = new int[5];
        for(int i=0;i<5;i++){
            Scanner scanner = new Scanner(System.in);
            dicePolls[i] = Integer.parseInt(scanner.next());
        }
        return dicePolls;
    }
    /**
     * Function that prase dice polls provided in String to Int
     * @param String array that needs to be converted to int
     * @return Int array of the dice polls
     */
    private int[] prasePollsStringToInt(String[] polls){
        int[] dicePolls = new int[5];
        for(int i=0;i<5;i++){
            dicePolls[i] = Integer.parseInt(polls[i]);
        }
            return dicePolls;
    }
    
    /**
     * Heart of the application, controller of the data input and output
     * @param mainArgs parameters from main function, that should define dice polls 
     */
    public void runApplication(String mainArgs[]){
        /**
         * Array that contain dice polls as integer;
         */
        int[] dicePolls = new int[5];
        /**
         * Array that contain player figures
         */
        int[] numbersOfPolls = new int[5];
        
        DicePoker dicePoker = new DicePoker();
        View view = new View();

        view.displayMessage("Witaj w dicePokerze - programie ktory sprwadzi co trafiłeś w kościanym pokerze!");
        
        if(mainArgs.length < 5 || mainArgs.length > 6){
            view.displayMessage("nie podałes argumentow, albo podales ich za malo/duzo. Prosze podaj je teraz:");
            dicePolls = getDicePolls();
        } else {
            view.displayMessage("Numery oczek zostaly podane jako argumenty");
            dicePolls = prasePollsStringToInt(mainArgs);
        }
        
        try{
            numbersOfPolls = dicePoker.checkPolls(dicePolls);
            view.showDicesPolls(numbersOfPolls);
        } catch(model.OutOfRangePollException ex) {
            // Prawopodobnie będzie trzeba stworzyć Loggera który bedzie obsługiwał wyświetlanie błedów.
            // Ale jako że w wymaganiach na razie tego nie ma wyświetlam to z pomoca metody z widoku.
             view.displayMessage(ex.toString());
        }
    }
}
