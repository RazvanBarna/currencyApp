package DataAccess;

import DataModel.Country;
import DataModel.CurrencyData;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonCurrencyConnection {
    private String country;

    public JsonCurrencyConnection(String country){
        this.country = country;
    }

    public CurrencyData connectToAPIAndFindCurrency(String country1){
        try {
            URL url = new URL("https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies/"+country+".json");
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

            Object object = jsonParser.parse(stringBuilder.toString());
            if(object instanceof JSONObject){
                org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) object;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date =sdf.parse((String) jsonObject.get("date"));
                JSONObject jsonObject1 =(JSONObject) jsonObject.get(country);
                double currencyWanted = (double) jsonObject1.get(country1);
                return new CurrencyData(date,currencyWanted);
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Problem with API currency connection");
        }
        return null;
    }

}
