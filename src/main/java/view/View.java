/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
* Class responsible for displaying data on the screen 
*
* @author Jakub Zaremba
* @version 1.0
* @since   2020-11-01 
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
    public void showDicesPolls(int[] dices){
        for(int i=0;i<dices.length;i++){
            System.out.println("kostk z " + (i+1) + " oczkiem jest " + dices[i]);
        }
    }
}
