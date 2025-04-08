
package com.example.demo1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class Practical8B3 extends Application {
    private int currentImage = 1;
    private Timeline timeline;
    private ImageView imageView = new ImageView();

    @Override
    public void start(Stage primaryStage) {
        Label titleLabel = new Label("Learning Java");
        titleLabel.setFont(Font.font("Arial", 32));

        TextField speedField = new TextField("500");
        TextField prefixField = new TextField("L");
        TextField countField = new TextField("1");
        TextField audioField = new TextField("");

        Button startButton = new Button("Start Animation");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        grid.add(new Label("Animation speed in milliseconds:"), 0, 0);
        grid.add(speedField, 1, 0);
        grid.add(new Label("Image file prefix:"), 0, 1);
        grid.add(prefixField, 1, 1);
        grid.add(new Label("Number of images:"), 0, 2);
        grid.add(countField, 1, 2);
        grid.add(new Label("Audio file URL:"), 0, 3);
        grid.add(audioField, 1, 3);

        VBox layout = new VBox(20, titleLabel, imageView, grid, startButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        startButton.setOnAction(e -> {
            int speed = Integer.parseInt(speedField.getText());
            String prefix = prefixField.getText();
            int count = Integer.parseInt(countField.getText());
            String audioURL = audioField.getText();

            if (!audioURL.isEmpty()) {
                MediaPlayer mediaPlayer = new MediaPlayer(new Media(audioURL));
                mediaPlayer.play();
            }

            currentImage = 1;
            if (timeline != null) timeline.stop();
            timeline = new Timeline(new KeyFrame(Duration.millis(speed), ev -> {
                File imgFile = new File("images/" + prefix + currentImage + ".png");
                if (imgFile.exists()) {
                    imageView.setImage(new Image(imgFile.toURI().toString()));
                }
                currentImage = (currentImage % count) + 1;
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        });

        Scene scene = new Scene(layout, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Practical 8-B-3");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
