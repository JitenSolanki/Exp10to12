package com.example.demo1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Collections;
import java.util.LinkedList;

public class Ex11_1 extends Application {

    private LinkedList<Integer> numberList = new LinkedList<>();
    private TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        // UI Components
        TextField inputField = new TextField();
        inputField.setPrefColumnCount(10);

        Button sortButton = new Button("Sort");
        Button shuffleButton = new Button("Shuffle");
        Button reverseButton = new Button("Reverse");

        // Top HBox for input
        HBox inputBox = new HBox(10);
        inputBox.getChildren().addAll(new Label("Enter a number:"), inputField);

        // Bottom HBox for buttons
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(sortButton, shuffleButton, reverseButton);

        // Set TextArea properties
        textArea.setEditable(false);
        textArea.setWrapText(true);

        // Main layout
        VBox root = new VBox(10);
        root.getChildren().addAll(inputBox, textArea, buttonBox);
        root.setStyle("-fx-padding: 10;");

        // Handle number input
        inputField.setOnAction(e -> {
            try {
                int number = Integer.parseInt(inputField.getText().trim());
                if (!numberList.contains(number)) {
                    numberList.add(number);
                    updateTextArea();
                }
                inputField.clear();
            } catch (NumberFormatException ex) {
                inputField.clear();
                inputField.setPromptText("Invalid number!");
            }
        });

        // Button actions
        sortButton.setOnAction(e -> {
            Collections.sort(numberList);
            updateTextArea();
        });

        shuffleButton.setOnAction(e -> {
            Collections.shuffle(numberList);
            updateTextArea();
        });

        reverseButton.setOnAction(e -> {
            Collections.reverse(numberList);
            updateTextArea();
        });

        // Show the stage
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Ex11_1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Update text area with current list
    private void updateTextArea() {
        StringBuilder sb = new StringBuilder();
        for (int num : numberList) {
            sb.append(num).append(" ");
        }
        textArea.setText(sb.toString().trim());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
