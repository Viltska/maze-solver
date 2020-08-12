package cs.helsinki.fi.gui;

import cs.helsinki.fi.maze.Maze;

// JavaFX
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

    // Maze size and scale settings.
    private final Maze maze = new Maze(21, 21);
    private final int scale = 18;
    private final Canvas canvas = new Canvas(maze.getWidth() * scale, maze.getHeight() * scale);

    /**
     * Method for launching a GUI window. creates a Maze class.
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
     * Method for drawing the maze on canvas.
     *
     * <p>
     * Values convention:0 = Path, 1 = Wall, 2 = Route, 3 = Start, 4 = Finish.
     * <p>
     */
    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int square;
        for (int i = 0; i < maze.getWidth() * scale; i = i + scale) {
            for (int j = 0; j < maze.getHeight() * scale; j = j + scale) {
                square = maze.getSquareValue(i / scale, j / scale);

                if (square == 0) {
                    gc.setFill(Color.ANTIQUEWHITE);
                    gc.fillRect(i, j, scale, scale);
                }
                if (square == 1) {
                    gc.setFill(Color.DARKSLATEGRAY);
                    gc.fillRect(i, j, scale, scale);
                }
                if (square == 2) {
                    gc.setFill(Color.ANTIQUEWHITE);
                    gc.fillRect(i, j, scale, scale);
                    gc.setFill(Color.YELLOW);
                    gc.fillOval(i, j, scale, scale);
                }
                if (square == 3) {
                    gc.setFill(Color.ANTIQUEWHITE);
                    gc.fillRect(i, j, scale, scale);
                    gc.setFill(Color.GREEN);
                    gc.fillOval(i, j, scale, scale);
                }
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
