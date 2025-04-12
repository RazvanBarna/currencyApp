package BusinessLogic;

import DataAccess.JsonCountryConnection;
import DataModel.Country;

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
}
