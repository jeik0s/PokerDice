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
        int userNumber;
        for(int i=0;i<5;i++){
            Scanner scanner = new Scanner(System.in);
            try{
                userNumber = scanner.nextInt();
                dicePollsList.add(userNumber);
            } catch (java.util.InputMismatchException ex){
                ex.printStackTrace();
            }
        }
        return dicePollsList;
    }
    /**
     * Function that prase dice polls provided from String to Int
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
     * @param mainArgs parameters from main function, that should defined as dice polls 
     */
    public void manageData(String mainArgs[]){
        /**
         * ArrayList that contain dice polls as integer;
         */
        List<Integer> dicePollsList = new ArrayList<>();
        
        DicePoker dicePoker = new DicePoker();
        View view = new View();

        view.ConsoleMessage("Witaj w dicePokerze","Program sprwadzi co trafiłeś w kościanym pokerze!");
        
        if(mainArgs.length != 5){
            while(dicePollsList.size() != 5 ){
                view.ConsoleMessage("nie podałes argumentow, albo podales ich za malo/duzo. Prosze podaj je teraz:");
                dicePollsList = getDicePolls();
            }
        } else {
            view.ConsoleMessage("Numery oczek zostaly podane jako argumenty");
            dicePollsList = prasePollsStringToInt(mainArgs);
        }
        
        view.displayMessage("Kostki maja oczka: ");
        view.showDicesPolls(dicePollsList);
        
        try{
            view.ConsoleMessage("Twój układ to " + dicePoker.checkFigure(dicePollsList) + ", fajnie!", "KONIEC GRY");
        } catch(model.DicePokerIllegalDataException ex) { 
            // Prawopodobnie będzie trzeba stworzyć Loggera który bedzie obsługiwał wyświetlanie błedów.
            // Ale jako że w wymaganiach na razie tego nie ma wyświetlam to z pomoca metody z widoku.
             view.ConsoleMessage(ex.toString());
        }
    }
}
