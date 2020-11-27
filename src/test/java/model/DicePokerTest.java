package model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Unit tests for poker game model
 * @author Jakub Zaremba
 * @version 2.0
 * @since   2020-11-14 
 */
public class DicePokerTest {
    /**
     * Test checks if we are able to pass ArrayList if one of the value is invalid.
     * @param number integers we defined  
     */
    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 7, 923})
    void testCheckPollsWithNotPossiblePollsNumbers(int number) {
        List<Integer> testNumbers = new ArrayList();
        testNumbers.add(1);
        testNumbers.add(3);
        testNumbers.add(3);
        testNumbers.add(6);
        testNumbers.add(number);
        DicePoker dicePoker = new DicePoker();
        try{
            dicePoker.checkFigure(testNumbers);
            fail("An exception should be thrown when we put poll that coudn't be on dice");
        } catch(DicePokerIllegalDataException ex){  
        }
    }
     /**
      * Test check if we are able to pass ArrayList with less element that model expects
      */
     @Test
     public void testCheckPollsArrayWithLessElementThanExpected() {
        List<Integer> testNumbers = new ArrayList();
        testNumbers.add(6);
        DicePoker dicePoker = new DicePoker();
        try{
            dicePoker.checkFigure(testNumbers);
            fail("An exception should be thrown when there are less element in collection that expected");
        } catch(DicePokerIllegalDataException ex){  
        }
     }
     
      /**
      * Test check if we are able to pass ArrayList with more element that model expects
      */
     @Test
     public void testCheckPollsArrayWithMoreElementThanExpected() {
        List<Integer> testNumbers = new ArrayList();
        testNumbers.add(6);
        testNumbers.add(6);
        testNumbers.add(6);
        testNumbers.add(6);
        testNumbers.add(6);
        testNumbers.add(6);
        DicePoker dicePoker = new DicePoker();
        try{
            dicePoker.checkFigure(testNumbers);
            fail("An exception should be thrown when there are more element in collection that expected");
        } catch(DicePokerIllegalDataException ex){  
        }
     }
     
      /**
      * Test check if we are able to pass empty ArrayList
      */
     @Test
     public void testCheckPollsEmptyArray() {
        DicePoker dicePoker = new DicePoker();
        List<Integer> testNumbers = new ArrayList();
        try{
            dicePoker.checkFigure(testNumbers);
            fail("An exception should be thrown when there are no elements in collection");
        } catch(DicePokerIllegalDataException ex){  
        }
     }
     
      /**
      * Test check if we are able to pass ArrayList if one of the value is null
      */
     @Test
     public void testCheckOneOfTheNumberIsNull() {
        List<Integer> testNumbers = new ArrayList();
        Integer a = null;
        testNumbers.add(5);
        testNumbers.add(a);
        testNumbers.add(3);
        testNumbers.add(4);
        testNumbers.add(6);
        DicePoker dicePoker = new DicePoker();
        try{
            dicePoker.checkFigure(testNumbers);
            fail("An exception should be thrown when there is null in collection");
        } catch(DicePokerIllegalDataException ex){  
        }
     }
     
}
