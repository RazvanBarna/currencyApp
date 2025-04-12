package DataAccess;

import DataModel.Country;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class JsonCountryConnection {

    public static void setCountriesInFile(){
        try {
            StringBuilder stringBuilder = readLines("https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@2025.4.11/v1/country.json");

            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = new JSONArray();

            Object object = jsonParser.parse(stringBuilder.toString());
            putLinesInJSON(object,jsonArray);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("country reader error");
        }
    }

    protected static  StringBuilder readLines(String filePath) throws Exception{
        URL url = new URL(filePath);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputString;
        StringBuilder stringBuilder = new StringBuilder();
        while((inputString = in.readLine()) != null){
            stringBuilder.append(inputString);
        }
        in.close();
        return stringBuilder;
    }

    private static void putLinesInJSON(Object object,JSONArray jsonArray) throws Exception{
        if(object instanceof org.json.simple.JSONObject) {
            org.json.simple.JSONObject jsonObject1 = (org.json.simple.JSONObject) object;
            Set<String> keySet = jsonObject1.keySet();

            for (String key : keySet) {
                org.json.simple.JSONObject countryData = (org.json.simple.JSONObject) jsonObject1.get(key);
                jsonArray.put(countryData);
            }
            FileWriter fileWriter = new FileWriter("src/main/java/DataAccess/countries.json");
            fileWriter.write(jsonArray.toString(4)); // Indentation of 4 spaces
            fileWriter.flush();
            fileWriter.close();
        }
    }

    public static List<Country> getCountriesFromFile(){
        try {
             StringBuilder stringBuilder = readLinesFromJSON("src/main/java/DataAccess/countries.json");

            JSONParser jsonParser = new JSONParser();
            Object o = jsonParser.parse(stringBuilder.toString());
            return getCountries(o);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("get countries problem");
        }
        return null;
    }

    private static List<Country> getCountries(Object o) {
        List<Country> countries = new ArrayList<>();
        if (o instanceof org.json.simple.JSONArray) {
            org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) o;
            for (Object object : jsonArray) {
                org.json.simple.JSONObject jsonObject1 = (org.json.simple.JSONObject) object;
                String country_name = (String) jsonObject1.get("country_name");
                String country_iso3 = (String) jsonObject1.get("country_iso3");
                String currency_name = (String) jsonObject1.get("currency_name");
                String currency_code = (String) jsonObject1.get("currency_code");
                String currency_number = (String) jsonObject1.get("currency_number");
                String country_iso_numeric = (String) jsonObject1.get("country_iso_numeric");
                Country country = new Country(country_name, country_iso3, country_iso_numeric, currency_name, currency_code, currency_number);
                countries.add(country);
            }
        }
        return countries;
    }

    private static StringBuilder readLinesFromJSON(String filePath) throws Exception {
        File file = new File(filePath);
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String inputString;
        StringBuilder stringBuilder = new StringBuilder();

        while((inputString = in.readLine()) != null){
            stringBuilder.append(inputString);
        }

        in.close();

        return stringBuilder;
    }

}
