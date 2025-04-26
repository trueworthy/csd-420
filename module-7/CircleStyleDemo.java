// Lea Trueworthy
// April 24, 2025
// M7 Programming assignment
// Description: Write a program that creates four circles in JavaFX and uses an external CSS file to style them with different colors and borders.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleStyleDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Pane to hold circles
        Pane pane = new Pane();

        // Four circles
        Circle c1 = new Circle(60, 60, 50); // top-left
        c1.getStyleClass().add("plaincircle");

        Circle c2 = new Circle(180, 60, 50); // top-right
        c2.setId("redcircle");

        Circle c3 = new Circle(60, 180, 50); // bottom-left
        c3.setId("greencircle");

        Circle c4 = new Circle(180, 180, 50); // bottom-right
        c4.getStyleClass().addAll("plaincircle", "circleborder");

        // Add all
        pane.getChildren().addAll(c1, c2, c3, c4);

        // Create scene and load external CSS
        Scene scene = new Scene(pane, 250, 250);
        scene.getStylesheets().add("style.css");

        // Set the stage
        primaryStage.setTitle("Styled Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
