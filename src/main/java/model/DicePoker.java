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
* @version 1.0
* @since   2020-11-01 
*/
public class DicePoker {
    /**
     * Method that shows player numbers of specific dice polls he got from a throw
     * @param dicePollsList integer List with dice polls
     * @return integer array with dice figures that player get from a throw
     * @throws OutOfRangePollException if the polls was higher that would be possible (in this case if dice poll is bigger than 6)
     */
    public List<Integer> checkPolls(List<Integer> dicePollsList) throws OutOfRangePollException{
        List<Integer> pollsList = new ArrayList<>();
        
        
        pollsList.add(frequency(dicePollsList, 1));
        pollsList.add(frequency(dicePollsList, 2));
        pollsList.add(frequency(dicePollsList, 3));
        pollsList.add(frequency(dicePollsList, 4));
        pollsList.add(frequency(dicePollsList, 5));
        pollsList.add(frequency(dicePollsList, 6));
        
        if(max(dicePollsList) > 6 || min(dicePollsList) < 1)
                throw new OutOfRangePollException("Została podana z oczkiem ktore nie istnieje.");
        
        return pollsList;
    }
}
