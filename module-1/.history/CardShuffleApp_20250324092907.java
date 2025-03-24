// Lea Trueworthy
// March 21, 2025
// M1 Programming assignment
// Description: Write a JavaFX program that displays four random card images from a "cards" folder, with a refresh button to redraw and using lambda expressions.

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardShuffleApp extends Application {

    // Method to get a random list of images
    private List<ImageView> getRandomCards() {
        List<ImageView> images = new ArrayList<>();
        List<Integer> cardNumbers = new ArrayList<>();

        // Add numbers 1 to 52 to the list
        for (int i = 1; i <= 52; i++) {
            cardNumbers.add(i);
        }

        // Shuffle the numbers to get random cards
        Collections.shuffle(cardNumbers);

        // Pick the first 4 random numbers from the shuffled list
        for (int i = 0; i < 4; i++) {
            int cardNumber = cardNumbers.get(i);
            String imagePath = "cards/" + cardNumber + ".png";

            try {
                // Load the image for the random card
                FileInputStream fileInputStream = new FileInputStream(imagePath);
                Image image = new Image(fileInputStream);
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(150);
                imageView.setFitWidth(100);
                images.add(imageView);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return images;
    }

    @Override
    public void start(Stage primaryStage) {
        // HBox to hold images horizontally
        HBox imageBox = new HBox(20);
        imageBox.setAlignment(Pos.CENTER);

        // Refresh button
        Button refreshButton = new Button("Refresh Cards");

        // Lambda to handle the button click action
        refreshButton.setOnAction(e -> {
            imageBox.getChildren().clear(); // Clear the existing images
            imageBox.getChildren().addAll(getRandomCards()); // Add new random images
        });

        imageBox.getChildren().addAll(getRandomCards());

        // VBox to hold the image box and refresh button vertically
        HBox root = new HBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(imageBox, refreshButton);

        // Set up the scene
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Card Shuffle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
