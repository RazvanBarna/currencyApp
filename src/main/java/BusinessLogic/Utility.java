package BusinessLogic;

import DataAccess.JsonCountryConnection;
import DataAccess.JsonCurrencyConnection;
import DataModel.Country;
import DataModel.CurrencyData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Utility {
    List<Country> countries = JsonCountryConnection.getCountriesFromFile();

    public Country findCurrencyName(String name){
        for(Country country : countries){
            String string1 = country.getCountryName().toLowerCase();
            String string2 = name.toLowerCase();
            if(string1.equals(string2)){
                return country;
            }
        }
        return null;
    }

    public  double convertCurrency(String fromCountry,String toCountry , double amount){
        JsonCurrencyConnection jsonCurrencyConnection = new JsonCurrencyConnection(fromCountry);
        CurrencyData currencyData = jsonCurrencyConnection.connectToAPIAndFindCurrency(toCountry);

        return amount* currencyData.getCurrencyValue();
    }
}
