package cs.helsinki.fi.gui;

import cs.helsinki.fi.maze.Maze;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Class for executing the Application.
 *
 * @author Ville Manninen
 */
public class GUI extends Application {

    private static Stage stage;

    // You can change height and width of tha maze here. 
    private static Maze maze;

    // You can change the scale here
    private static int scale;
    private static Canvas canvas;

    /**
     * Launches a GUI window and draws the solved maze.
     *
     * @param stage - primary stage
     * @throws Exception - Application Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        // Load stage icon image
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String imageUrl = classLoader.getResource("icon.png").toExternalForm();
            Image image = new Image(imageUrl);
            stage.getIcons().add(image);

        } catch (Exception e) {
            System.out.println("Problem loading icon image" + e);
        }

        stage.setScene(getStartScene(stage));
        stage.setResizable(false);
        stage.setTitle("Maze generator");
        stage.setMinWidth(400);
        stage.setMinHeight(400);
        stage.show();
        GUI.stage = stage;
    }

    /**
     * Creates a start Scene where user can choose the size of the maze.
     *
     * @param stage - main Stage of the Application
     * @return startScene - starting Scene
     */
    public static Scene getStartScene(Stage stage) {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(50);

        Label label = new Label("Maze solver - select the size of the maze");
        gp.add(label, 0, 0);

        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);

        ToggleGroup sizeGroup = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Small");
        rb1.setToggleGroup(sizeGroup);
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("Medium");
        rb2.setToggleGroup(sizeGroup);
        RadioButton rb3 = new RadioButton("Large");
        rb3.setToggleGroup(sizeGroup);
        RadioButton rb4 = new RadioButton("Max");
        rb4.setToggleGroup(sizeGroup);

        hb.getChildren().addAll(rb1, rb2, rb3, rb4);
        hb.setPadding(new Insets(10));
        hb.setSpacing(20);

        gp.add(hb, 0, 1);

        HBox hb2 = new HBox();
        hb.setAlignment(Pos.CENTER);
        ToggleGroup solveGroup = new ToggleGroup();
        RadioButton sb1 = new RadioButton("Iterative");
        sb1.setToggleGroup(solveGroup);
        sb1.setSelected(true);
        RadioButton sb2 = new RadioButton("Recursive");
        sb2.setToggleGroup(solveGroup);

        hb2.getChildren().addAll(sb1, sb2);
        hb2.setPadding(new Insets(10));
        hb2.setSpacing(20);

        gp.add(hb2, 0, 2);

        Button btn = new Button("Solve");

        btn.setOnAction(e -> {
            RadioButton selected = (RadioButton) sizeGroup.getSelectedToggle();
            String selectedString = selected.getText();

            RadioButton selected2 = (RadioButton) solveGroup.getSelectedToggle();
            String selectedString2 = selected2.getText();

            if (selectedString2.equals("Recursive")) {
                String setting = "Recursive";
                if (selectedString.equals("Small")) {
                    stage.setScene(getSolveScene(41, 41, 12, setting));
                    stage.setTitle("Maze generator - Recursive Small");
                    stage.centerOnScreen();

                }

                if (selectedString.equals("Medium")) {
                    stage.setScene(getSolveScene(81, 81, 8, setting));
                    stage.setTitle("Maze generator - Recursive Medium");
                    stage.centerOnScreen();

                }
                // StackOverflow error when over 500 x 500
                if (selectedString.equals("Large")) {
                    stage.setScene(getSolveScene(201, 101, 6, setting));
                    stage.setTitle("Maze generator - Recursive Large");
                    stage.centerOnScreen();

                }

                if (selectedString.equals("Max")) {
                    stage.setScene(getSolveScene(501, 501, 6, setting));
                    stage.setTitle("Maze generator - Recursive Max");
                    stage.centerOnScreen();

                }

            } else {
                String setting = "Loop";
                if (selectedString.equals("Small")) {
                    stage.setScene(getSolveScene(41, 41, 12, setting));
                    stage.setTitle("Maze generator - Iterative Small");
                    stage.centerOnScreen();

                }

                if (selectedString.equals("Medium")) {
                    stage.setScene(getSolveScene(81, 81, 8, setting));
                    stage.setTitle("Maze generator - Iterative Medium");
                    stage.centerOnScreen();

                }
                if (selectedString.equals("Large")) {
                    stage.setScene(getSolveScene(201, 101, 6, setting));
                    stage.setTitle("Maze generator - Iterative Large");
                    stage.centerOnScreen();

                }
                if (selectedString.equals("Max")) {
                    stage.setScene(getSolveScene(801, 301, 3, setting));
                    stage.setTitle("Maze generator - Iterative Max");
                    stage.centerOnScreen();
                }
            }

        });

        gp.add(btn, 0, 3);

        gp.setMinWidth(400);
        gp.setMinHeight(400);

        Scene start = new Scene(gp);
        return start;
    }

    /**
     * Returns a canvas drawing of the solved maze.
     *
     * @param width - width of the maze that is solved
     * @param height - height of the maze that is solved
     * @param scale - scale of a square inside the maze
     * @param setting - String name of the algorithm that is used
     * @return solvedScene - Scene with canvas of the solved maze
     */
    public static Scene getSolveScene(int width, int height, int scale, String setting) {
        GUI.maze = new Maze(width, height);
        GUI.scale = scale;

        GUI.canvas = new Canvas(maze.getWidth() * scale, maze.getHeight() * scale);
        Group root = new Group();
        root.getChildren().add(canvas);

        Button returnButton = createReturnButton(stage);
        returnButton.setTranslateX((width * scale) / 2);
        returnButton.setTranslateY(10);
        root.getChildren().add(returnButton);

        Scene solveScene = new Scene(root, maze.getWidth() * scale, maze.getHeight() * scale, Color.BLUE);
        maze.generate();

        if (setting.equals("Recursive")) {
            maze.solve(setting);
            draw();
        } else {
            maze.solve();
            draw();
        }

        return solveScene;
    }

    /**
     * Creates a button that returns to start Scene.
     *
     * @param stage - main stage of the GUI
     * @return Button - return button
     */
    public static Button createReturnButton(Stage stage) {
        Button button = new Button("Return");

        button.setOnAction(e -> {
            stage.setScene(getStartScene(stage));
            stage.centerOnScreen();
        });

        return button;
    }

    /**
     * Draws the maze to canvas.
     *
     */
    public static void draw() {
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
