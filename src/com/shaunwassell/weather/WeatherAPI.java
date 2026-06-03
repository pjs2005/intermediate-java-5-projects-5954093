package com.shaunwassell.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class WeatherAPI {

    private final String API_KEY = "API_KEY_HERE"; // Replace with your actual API key
    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/forecast/";

    public String getForecast(String city) throws IOException {
        String apiUrl = BASE_URL + "?q=" + URLEncoder.encode(city, "UTF-8") + "&appid=" + API_KEY + "&units=metric" ;
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return response.toString();
    }


}
