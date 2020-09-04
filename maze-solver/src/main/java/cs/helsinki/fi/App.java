package cs.helsinki.fi;

import cs.helsinki.fi.gui.GUI;
import cs.helsinki.fi.util.PerformanceTester;
import javafx.application.Application;

/**
 * Main class for programs.
 *
 * @version 1.6
 * @author Ville Manninen
 */
public class App {

    /**
     * Main method if has no arguments launches GUI class, else runs performance
     * tests.
     *
     * @param args - main class arguments.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            Application.launch(GUI.class);

        } else {
            PerformanceTester pf = new PerformanceTester();
            pf.runAllTests();
        }
    }
}
