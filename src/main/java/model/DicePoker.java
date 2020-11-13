package model;

import java.util.Arrays;

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
     * @param dicePolls integer array with dice polls
     * @return integer array with dice figures that player get from a throw
     * @throws OutOfRangePollException if the polls was higher that would be possible (in this case if dice poll is bigger than 6)
     */
    public int[] checkPolls(int[] dicePolls) throws OutOfRangePollException{
        int[] polls = new int[6];
        Arrays.fill(polls, 0);
        for(int i=0;i<dicePolls.length;i++){
            if(dicePolls[i] == 1)
                    polls[0] = polls[0] + 1;
            if(dicePolls[i] == 2)
                    polls[1] = polls[1] + 1;
            if(dicePolls[i] == 3)
                    polls[2] = polls[2] + 1;
            if(dicePolls[i] == 4)
                    polls[3] = polls[3] + 1;
            if(dicePolls[i] == 5)
                    polls[4] = polls[4] + 1;
            if(dicePolls[i] == 6)
                    polls[5] = polls[5] + 1;
            if(dicePolls[i] > 6)
                throw new OutOfRangePollException("Kostak z takim oczkiem " + dicePolls[i] + " nie istnieje.");
        }
        return polls;
    }
}
