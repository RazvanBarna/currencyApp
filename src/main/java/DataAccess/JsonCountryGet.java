package DataAccess;

import org.json.JSONArray;
import org.json.JSONObject;

import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;

public class JsonCountryGet {
    JSONObject jsonObject;

    public  JsonCountryGet() {
        jsonObject = new JSONObject();
    }

    public static void setCountriesInFile(){
        try {
            URL url = new URL("https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@2025.4.11/v1/country.json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputString;
            StringBuilder stringBuilder = new StringBuilder();
            while((inputString = in.readLine()) != null){
                stringBuilder.append(inputString);
            }
            in.close();

            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = new JSONArray();

            Object object = jsonParser.parse(stringBuilder.toString());
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
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("country reader error");
        }
    }

    public static void getCountriesFromFile(){
        try {
            File file = new File("src/main/java/DataAccess/countries.json");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String string;
            StringBuilder stringBuilder= new StringBuilder();
            while((string = bufferedReader.readLine()) != null){
                stringBuilder.append(string);
            }
            bufferedReader.close();

            JSONParser jsonParser = new JSONParser();
            Object o = jsonParser.parse(stringBuilder.toString());
            if(o instanceof org.json.simple.JSONArray){
                org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) o;
                for(Object object : jsonArray){
                    System.out.println(object);//parse to country
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("get countries problem");
        }
    }

    public static void main(String[] args) {
        JsonCountryGet.getCountriesFromFile();
    }

}
