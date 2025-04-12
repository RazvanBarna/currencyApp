# Currency Converter Application

## Description
This application allows users to retrieve information about a country's currency and perform currency conversions. The app is built using JavaFX for the graphical user interface and uses an external API to fetch exchange rates. Users can search for the currency of a country, view detailed information about it, and perform conversions between different currencies.

## Features

1. **Currency Lookup for a Country**: Enter the name of a country, and the application will display its currency, including the full name and the currency code.
2. **Currency Conversion**: Enter an amount in one currency and select a target currency. The app will calculate the equivalent amount in the target currency using the exchange rates retrieved from the API.
3. **Display Current Date**: The app shows the current date to provide context to the user.

## How It Works

1. **Currency Lookup**: The application makes a request to an external API to fetch information about the currencies available.
2. **Currency Conversion**: After obtaining the exchange rates, the application calculates the equivalent amount in the target currency.
3. **User Interface**: The application uses JavaFX to create a user-friendly interface for easy interaction.

## API Used

The application fetches real-time currency data from the [Fawaz Ahmed Currency API](https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies/) for accurate and up-to-date exchange rates.

## Technologies Used

- **JavaFX**: For building the graphical user interface (GUI).
- **JSON Parsing**: To process data retrieved from the API.
- **Java 8+**: The core Java version for the application.

## How to Run the Application

1. Clone this repository to your local machine.
2. Ensure that you have Java 8 or a later version installed.
3. Download and include JavaFX libraries in your project. You can get JavaFX from [here](https://openjfx.io/).
4. Build and run the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
5. The application will launch a window where you can interact with the currency functionality.

## Example of API Request

The application fetches the data from the following endpoint:
