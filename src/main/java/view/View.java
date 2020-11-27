/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.util.List;
/**
* Class responsible for displaying data on the screen 
*
* @author Jakub Zaremba
* @version 2.0
* @since   2020-11-14
*/
public class View {
    /**
     * @deprecated
     * Simple method that display give message, replaced with ConsoleMessage which can take more arguments
     * @param message information that you want to display on the screen
     */
    @Deprecated
    public void displayMessage(String message){
        System.out.println(message);
    }
    
    /**
     * Method allows you to display message in console, and since it has changeable numbers of parameters you can display more than one message. 
     * @param message String array - contains messages you want to display.
     */
    public void ConsoleMessage(String... message){
        for(int i=0;i<message.length;i++)
            System.out.println("Game console message - "+message[i]);
    }
    /**
     * Method that display dice polls 
     * @param dices integer array with dice polls
     */
    public void showDicesPolls(List<Integer> dices){
        System.out.print("Game console message - ");
        for (Integer dice : dices) {
            System.out.print(dice+ ", ");
        }
        System.out.println("");
    }
}
