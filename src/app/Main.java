//@author Knobs
package app;

import gui.Dashboard;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Dashboard().setVisible(true);});
        }//end main    
}//end class
