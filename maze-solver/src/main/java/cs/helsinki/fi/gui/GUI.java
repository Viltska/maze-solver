package cs.helsinki.fi.gui;

import cs.helsinki.fi.maze.Maze;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.image.Image;

/**
 * Class for executing the Application.
 *
 * @author Ville Manninen
 */
public class GUI extends Application {

    // You can change height and width of tha maze here. 
    private final Maze maze = new Maze(41, 41);

    // You can change the scale here
    private final int scale = 14;

    private final Canvas canvas = new Canvas(maze.getWidth() * scale, maze.getHeight() * scale);

    /**
     * Launches a GUI window and draws the solved maze.
     *
     * @param stage - primary stage
     * @throws Exception - Application Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        root.getChildren().add(canvas);
        Scene s = new Scene(root, maze.getWidth() * scale, maze.getHeight() * scale, Color.BLUE);
        maze.generate();
        maze.solve();
        draw();

        // Load stage icon image
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String imageUrl = classLoader.getResource("icon.png").toExternalForm();
            Image image = new Image(imageUrl);
            stage.getIcons().add(image);

        } catch (Exception e) {
            System.out.println("Problem loading icon image" + e);
        }

        stage.setScene(s);
        stage.setResizable(false);
        stage.setTitle("Maze generator");
        stage.show();
    }

    /**
     * Draws the current maze.
     *
     */
    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int square;
        for (int i = 0; i < maze.getWidth() * scale; i = i + scale) {
            for (int j = 0; j < maze.getHeight() * scale; j = j + scale) {
                square = maze.getSquareValue(i / scale, j / scale);

                // Path
                if (square == 0) {
                    gc.setFill(Color.ANTIQUEWHITE);
                    gc.fillRect(i, j, scale, scale);
                }
                // Wall
                if (square == 1) {
                    gc.setFill(Color.DARKSLATEGRAY);
                    gc.fillRect(i, j, scale, scale);
                }
                // Visited path
                if (square == 2) {
                    gc.setFill(Color.ANTIQUEWHITE);
                    gc.fillRect(i, j, scale, scale);
                    gc.setFill(Color.YELLOW);
                    gc.fillOval(i, j, scale, scale);
                }
                // Start
                if (square == 3) {
                    gc.setFill(Color.ANTIQUEWHITE);
                    gc.fillRect(i, j, scale, scale);
                    gc.setFill(Color.GREEN);
                    gc.fillOval(i, j, scale, scale);
                }
                // Finish
                if (square == 4) {
                    gc.setFill(Color.ANTIQUEWHITE);
                    gc.fillRect(i, j, scale, scale);
                    gc.setFill(Color.RED);
                    gc.fillOval(i, j, scale, scale);

                }
            }
        }
    }
}
