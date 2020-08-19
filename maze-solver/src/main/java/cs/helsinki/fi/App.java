package cs.helsinki.fi;

import cs.helsinki.fi.gui.GUI;
import javafx.application.Application;

/**
 * Main class for programs.
 *
 * @version 1.5
 * @author Ville Manninen
 */
public class App {

    /**
     * Main method - launches GUI class.
     *
     * @param args - main class arguments.
     */
    public static void main(String[] args) {
        try {
            Application.launch(GUI.class);
        } catch (StackOverflowError e) {
            System.out.println("Stack overflow error: " + e);

        }
    }
}
