/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

/**
 *
 * @author jzaremba
 */
public class DicePokerTest {
    
    public DicePokerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    
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
            dicePoker.checkPolls(testNumbers);
        } catch(OutOfRangePollException ex){  
        }
    }
     
     @Test
     public void testCheckPollsArrayWithLessElementThanExpected() {
         
     }
     
     @Test
     public void testCheckPollsArrayWithMoreElementThanExpected() {
         
     }
     
     @Test
     public void testCheckPollsEmptyArray() {

     }
     
     // Fajnie bo udało mi się znaleźć sytuacje który powinienem obsłużyć:)
     @Test
     public void testCheckOneOfTheNumberIsNull() {
        List<Integer> testNumbers = new ArrayList();
        testNumbers.add(1);
        testNumbers.add(null);
        testNumbers.add(3);
        testNumbers.add(4);
        testNumbers.add(6);
        DicePoker dicePoker = new DicePoker();
        dicePoker.checkPolls(testNumbers);
     }
    
}
