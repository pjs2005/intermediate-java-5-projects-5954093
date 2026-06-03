package com.shaunwassell.weather;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherResponseParser {
    public void parseAndPrint(String jsonResponse) {
        JSONObject jsonObject = new JSONObject(jsonResponse);

        if(jsonObject.getInt("cod") == 200) {
            System.out.println("Weather forcast for city:" );
            JSONArray forecasts = jsonObject.getJSONArray("list");
            for (int i = 0; i < forecasts.length(); i++) {
                JSONObject forcase = forecasts.getJSONObject(i);
                long timestamp = forcase.getLong("dt");
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp * 1000));
                double temp = forcase.getJSONObject("main").getDouble("temp");
                int humidity = forcase.getJSONObject("main").getInt("humidity");
                String description = forcase.getJSONArray("weather").getJSONObject(0).getString("description");
                System.out.println(date + ": " + temp + "C,  Humidity: " + humidity + "%, " + description);


            }
        } else {
            String errorMessage = jsonObject.getString("message");
            System.out.println("Error: " + errorMessage);
        }
        
        // Implement JSON parsing logic here to extract relevant weather data
        // You can use libraries like org.json or Gson for parsing
    }

}
