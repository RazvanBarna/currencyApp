package GUI;

import BusinessLogic.Utility;
import DataModel.Country;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainPage extends Application {
    Utility utility = new Utility();

    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: #F0F8FF; -fx-padding: 20px;");

        Label label = new Label("Welcome to the Currency Page!");
        label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2c3e50; -fx-alignment: center; -fx-padding: 10px;");

        TextField countryInput = new TextField();
        countryInput.setPromptText("Enter a country...");
        countryInput.setStyle("-fx-font-size: 14px; -fx-padding: 10px; -fx-background-color: #ffffff; -fx-border-radius: 5px; -fx-border-color: #ccc;");
        countryInput.setMaxWidth(250);

        Button submitButton = new Button("Find out currency for this country");
        submitButton.setStyle("-fx-font-size: 14px; -fx-padding: 8px 16px; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-border-radius: 5px;");

        Label messageLabel = new Label("");
        messageLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        submitButton.setOnAction(e -> {
            Country country = utility.findCurrencyName(countryInput.getText());
            if (country != null) {
                messageLabel.setText("The currency is: " + country.getCurrencyName() +",short form:"+country.getCurrencyCode());
                messageLabel.setTextFill(Color.GREEN);
            } else {
                // Actualizăm mesajul pentru eroare
                messageLabel.setText("Country not found!");
                messageLabel.setTextFill(Color.RED);
            }
        });

        vbox.getChildren().addAll(label, countryInput, submitButton, messageLabel);

        Scene scene = new Scene(vbox, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/mainPage.css").toExternalForm());

        primaryStage.setTitle("Currency Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
