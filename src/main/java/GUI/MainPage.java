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

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainPage extends Application {
    Utility utility = new Utility();

    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: #F0F8FF; -fx-padding: 20px;");

        Label label = new Label("Welcome to the Currency Page!");
        label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2c3e50; -fx-alignment: center; -fx-padding: 10px;");

        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Label dateLabel = new Label("Date: " + currentDate);
        dateLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #7f8c8d; -fx-padding: 5px;");

        TextField countryInput = new TextField();
        countryInput.setPromptText("Enter a country...");
        countryInput.setMaxWidth(250);

        TextField currencyCodeInput = new TextField();
        currencyCodeInput.setPromptText("Enter currency code (e.g. USD)...");

        TextField amountInput = new TextField();
        amountInput.setPromptText("Enter amount to convert...");

        TextField targetCurrencyInput = new TextField();
        targetCurrencyInput.setPromptText("Enter target currency code (e.g. EUR)...");

        // Butoane
        Button submitButton = new Button("Find out currency for this country");
        Button convertButton = new Button("Convert currency");

        Label messageLabel = new Label("");

        submitButton.setOnAction(e -> {
            Country country = utility.findCurrencyName(countryInput.getText());
            if (country != null) {
                messageLabel.setText("The currency is: " + country.getCurrencyName() + ", short form: " + country.getCurrencyCode());
                messageLabel.setTextFill(Color.GREEN);
            } else {
                messageLabel.setText("Country not found!");
                messageLabel.setTextFill(Color.RED);
            }
        });

        convertButton.setOnAction(e -> {
            try {
                String fromCurrency = currencyCodeInput.getText().toLowerCase();
                String toCurrency = targetCurrencyInput.getText().toLowerCase();
                double amount = Double.parseDouble(amountInput.getText());

                double convertedAmount = utility.convertCurrency(fromCurrency, toCurrency, amount);
                messageLabel.setText("Converted amount: " + convertedAmount);
                messageLabel.setTextFill(Color.BLUE);
            } catch (NumberFormatException ex) {
                messageLabel.setText("Please enter a valid amount!");
                messageLabel.setTextFill(Color.RED);
            }
        });

        vbox.getChildren().addAll(label, dateLabel, countryInput, submitButton, currencyCodeInput, amountInput, targetCurrencyInput, convertButton, messageLabel);

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
