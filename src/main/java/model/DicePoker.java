package model;

import java.util.ArrayList;
import static java.util.Collections.frequency;
import static java.util.Collections.max;
import static java.util.Collections.min;
import java.util.List;

/**
* Base business logic model class that should represents player results
*
* @author Jakub Zaremba
* @version 2.0
* @since   2020-11-14 
*/
public class DicePoker {
        /**
         * Method that identify poker figures
         * @param dicePollsList integer list of dice polls rate
         * @return String with poker figure name
         */
        private String defineFigureFromPolls(List<Integer> dicePollsList){
        
            String finalResult;
            
            if(frequency(dicePollsList,5) == 1){
                finalResult = "Poker";
            }
            else if(frequency(dicePollsList,4) == 1){
                finalResult = "Kareta";
            }
            else if(frequency(dicePollsList,3) == 1 && frequency(dicePollsList,2) == 1){
                finalResult = "Full";
            }
            else if(frequency(dicePollsList,3) == 1){
                finalResult = "Trojka";
            }
            else if(frequency(dicePollsList,1) == 5 &&  dicePollsList.get(0) == 0){
                finalResult = "Duzy strit";
            }
            else if(frequency(dicePollsList,1) == 5 && dicePollsList.get(dicePollsList.size() - 1) == 0){
                finalResult = "Maly strit";
            }
            else if(dicePollsList.get(0) > 0 && dicePollsList.get(2) > 0 && dicePollsList.get(4) > 0 && dicePollsList.get(1) == 0 && dicePollsList.get(3) == 0 && dicePollsList.get(5) == 0){
                finalResult = "Same nieparzyste";
            }
            else if(dicePollsList.get(1) > 0 && dicePollsList.get(3) > 0 && dicePollsList.get(5) > 0 && dicePollsList.get(0) == 0 && dicePollsList.get(2) == 0 && dicePollsList.get(4) == 0){
                finalResult = "Same parzyste";
            }
            else if(frequency(dicePollsList,2) == 2){
                finalResult = "Dwie pary";
            }
            else if(frequency(dicePollsList,2) == 1){
                finalResult = "jedna para";
            }
            else {
                finalResult = "nic";
            }
        
        return finalResult;
    }
    
    /**
     * Method that count player numbers of specific dice polls he got from a throw
     * @param dicePollsList integer List with dice polls
     * @return String with poker figure name
     * @throws DicePokerIllegalDataException - if list was empty, if one of the value was null, if someone set polls number that doesn't exist, more or less elements in list that needed
     */
    public String checkFigure(List<Integer> dicePollsList) throws DicePokerIllegalDataException{
        /**
        * ArrayList that contain numbers of specific dice polls player got from a throw
        */
        List<Integer> pollsList = new ArrayList<>();
        /**
         * Will contain name of the poker figure
         */
        String figureResult;
        
        if(dicePollsList.isEmpty())
           throw new DicePokerIllegalDataException("Zbior który wyslales jest pusty"); 
        
        if(dicePollsList.contains(null))
            throw new DicePokerIllegalDataException("Jedna z wartosci jest nullem");
        
        if(max(dicePollsList) > 6 || min(dicePollsList) < 1)
            throw new DicePokerIllegalDataException("Została podana kostka z oczkiem ktore nie istnieje.");     
        
        if(dicePollsList.size() != 5)
            throw new DicePokerIllegalDataException("Podana liczba elemetow to '" + dicePollsList.size() + "' docelowa powinna wynoscic '5'");
                    
        pollsList.add(frequency(dicePollsList, 1));
        pollsList.add(frequency(dicePollsList, 2));
        pollsList.add(frequency(dicePollsList, 3));
        pollsList.add(frequency(dicePollsList, 4));
        pollsList.add(frequency(dicePollsList, 5));
        pollsList.add(frequency(dicePollsList, 6));
        
        figureResult = defineFigureFromPolls(pollsList);
        
        return figureResult;
    }
    
    
    
    
}
