package com.example.demo1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RegistrationForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Registration Form");

        // --- Name Fields ---
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("First Name");

        TextField middleNameField = new TextField();
        middleNameField.setPromptText("Middle Name");

        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Last Name");

        // --- Email Field ---
        TextField emailField = new TextField();
        emailField.setPromptText("Email Address");

        // --- Mobile Field ---
        TextField mobileField = new TextField();
        mobileField.setPromptText("Mobile Number");

        // --- Date of Birth ---
        ComboBox<String> dayBox = new ComboBox<>();
        for (int i = 1; i <= 31; i++) dayBox.getItems().add(String.valueOf(i));
        dayBox.setPromptText("Day");

        ComboBox<String> monthBox = new ComboBox<>();
        monthBox.getItems().addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        monthBox.setPromptText("Month");

        ComboBox<String> yearBox = new ComboBox<>();
        for (int i = 1980; i <= 2024; i++) yearBox.getItems().add(String.valueOf(i));
        yearBox.setPromptText("Year");

        // --- Gender ---
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton male = new RadioButton("Male");
        male.setToggleGroup(genderGroup);
        RadioButton female = new RadioButton("Female");
        female.setToggleGroup(genderGroup);

        // --- Languages ---
        CheckBox hindi = new CheckBox("Hindi");
        CheckBox gujarati = new CheckBox("Gujarati");
        CheckBox english = new CheckBox("English");

        // --- Buttons ---
        Button submitBtn = new Button("Submit");
        Button cancelBtn = new Button("Cancel");

        // --- Form Layout ---
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(new Label("First Name:"), 0, 0);
        grid.add(firstNameField, 1, 0);
        grid.add(new Label("Middle Name:"), 0, 1);
        grid.add(middleNameField, 1, 1);
        grid.add(new Label("Last Name:"), 0, 2);
        grid.add(lastNameField, 1, 2);
        grid.add(new Label("Email:"), 0, 3);
        grid.add(emailField, 1, 3);
        grid.add(new Label("Mobile:"), 0, 4);
        grid.add(mobileField, 1, 4);
        grid.add(new Label("DOB:"), 0, 5);
        HBox dobBox = new HBox(5, dayBox, monthBox, yearBox);
        grid.add(dobBox, 1, 5);
        grid.add(new Label("Gender:"), 0, 6);
        HBox genderBox = new HBox(10, male, female);
        grid.add(genderBox, 1, 6);
        grid.add(new Label("Languages Known:"), 0, 7);
        HBox langBox = new HBox(10, hindi, gujarati, english);
        grid.add(langBox, 1, 7);
        HBox btnBox = new HBox(10, submitBtn, cancelBtn);
        grid.add(btnBox, 1, 8);

        Scene formScene = new Scene(grid, 500, 500);

        // --- Submit Action ---
        submitBtn.setOnAction(e -> {
            if (firstNameField.getText().isEmpty() ||
                    lastNameField.getText().isEmpty() ||
                    emailField.getText().isEmpty() ||
                    mobileField.getText().isEmpty() ||
                    dayBox.getValue() == null ||
                    monthBox.getValue() == null ||
                    yearBox.getValue() == null ||
                    genderGroup.getSelectedToggle() == null) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill all required fields.");
                return;
            }

            if (!emailField.getText().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "Please enter a valid email.");
                return;
            }

            if (mobileField.getText().length() != 10 || !mobileField.getText().matches("\\d+")) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "Mobile number must be 10 digits.");
                return;
            }

            // If all is good → Show Welcome screen
            Label welcomeLabel = new Label("Welcome, " + firstNameField.getText() + "!");
            VBox welcomeLayout = new VBox(20, welcomeLabel);
            welcomeLayout.setPadding(new Insets(50));
            Scene welcomeScene = new Scene(welcomeLayout, 300, 200);
            primaryStage.setScene(welcomeScene);
        });

        // --- Cancel Action ---
        cancelBtn.setOnAction(e -> {
            firstNameField.clear();
            middleNameField.clear();
            lastNameField.clear();
            emailField.clear();
            mobileField.clear();
            dayBox.getSelectionModel().clearSelection();
            monthBox.getSelectionModel().clearSelection();
            yearBox.getSelectionModel().clearSelection();
            genderGroup.selectToggle(null);
            hindi.setSelected(false);
            gujarati.setSelected(false);
            english.setSelected(false);
        });

        primaryStage.setScene(formScene);
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
