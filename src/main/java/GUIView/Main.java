/*
 * Gra w kości - rozpoznawanie układów pokerowych. Otrzymuje Pan 5 wyników rzutu kosci i rozpoznaje Pan jako to układ: trójka, strit itp.
 */
package GUIView;

/**
* Main class that allows to run application
* @author Jakub Zaremba
* @version 3.0
* @since   2020-12-06 
 */
public class Main {
    /**
     * static void function allows to run application, with or without dice polls parameters provided as arguments
     * @param args array of five numeric values
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dicePokerGUI(args).setVisible(true);
            }
        });
    }
}
