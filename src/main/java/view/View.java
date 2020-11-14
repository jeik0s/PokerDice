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
     * Simple method that display give message
     * @param message information that you want to display on the screen
     */
    public void displayMessage(String message){
        System.out.println(message);
    }
    /**
     * Method that display dice figures 
     * @param dices integer array with dice figures
     */
    public void showDicesPolls(List<Integer> dices){
        int i = 0;
        for (Integer element : dices) {
            i++;
            System.out.println("kostk z " + (i) + " oczkiem jest " + element);
        }
    }
}
