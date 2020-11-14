/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
* Exception class, to throw exception
*
* @author Jakub Zaremba
* @version 2.0
* @since   2020-11-14
*/
public class OutOfRangePollException extends RuntimeException {
    public OutOfRangePollException(String message){
        super(message);
    }
}
