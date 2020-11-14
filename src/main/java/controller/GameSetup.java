package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.DicePoker;
import view.View;

/**
* Main controller class responsible for controlling data flow between model and view
*
* @author Jakub Zaremba
* @version 2.0
* @since   2020-11-14 
*/
public class GameSetup {
    /**
     * Function allows user to put number of dice polls
     * @return Integer List of dices polls
     */
    private List<Integer> getDicePolls(){
        List<Integer> dicePollsList = new ArrayList<>();
        for(int i=0;i<5;i++){
            Scanner scanner = new Scanner(System.in);
            dicePollsList.add(Integer.parseInt(scanner.next()));
        }
        return dicePollsList;
    }
    /**
     * Function that prase dice polls provided in String to Int
     * @param String array that needs to be converted to int
     * @return Integer List of the dice polls
     */
    private List<Integer> prasePollsStringToInt(String[] polls){
        List<Integer> dicePollsList = new ArrayList<>();
        for(int i=0;i<5;i++){
            dicePollsList.add(Integer.parseInt(polls[i]));
        }
            return dicePollsList;
    }
    
    /**
     * Heart of the application, controller of the data input and output
     * @param mainArgs parameters from main function, that should define dice polls 
     */
    public void manageData(String mainArgs[]){
        /**
         * ArrayList that contain dice polls as integer;
         */
        List<Integer> dicePollsList = new ArrayList<>();
        /**
         * ArrayList that contain player figures
         */
        List<Integer> numbersOfPollsList = new ArrayList<>();
        
        DicePoker dicePoker = new DicePoker();
        View view = new View();

        view.displayMessage("Witaj w dicePokerze - programie ktory sprwadzi co trafiłeś w kościanym pokerze!");
        
        if(mainArgs.length < 5 || mainArgs.length > 6){
            view.displayMessage("nie podałes argumentow, albo podales ich za malo/duzo. Prosze podaj je teraz:");
            dicePollsList = getDicePolls();
        } else {
            view.displayMessage("Numery oczek zostaly podane jako argumenty");
            dicePollsList = prasePollsStringToInt(mainArgs);
        }
        
        try{
            numbersOfPollsList = dicePoker.checkPolls(dicePollsList);
            view.showDicesPolls(numbersOfPollsList);
        } catch(model.OutOfRangePollException ex) {
            // Prawopodobnie będzie trzeba stworzyć Loggera który bedzie obsługiwał wyświetlanie błedów.
            // Ale jako że w wymaganiach na razie tego nie ma wyświetlam to z pomoca metody z widoku.
             view.displayMessage(ex.toString());
        }
    }
}
