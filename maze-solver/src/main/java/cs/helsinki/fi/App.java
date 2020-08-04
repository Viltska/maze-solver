package cs.helsinki.fi;

import cs.helsinki.fi.gui.GUI;
import javafx.application.Application;

/**
 * Class for launching Application.
 *
 * @version 1.0-SNAPSHOT
 * @author Ville Manninen
 */
public class App {

    /**
     * Main method - launches GUI class.
     *
     * @param args - main class arguments.
     */
    public static void main(String[] args) {
        Application.launch(GUI.class);
    }
}
