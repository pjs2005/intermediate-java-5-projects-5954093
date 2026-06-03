package com.shaunwassell.weather;

import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter city name:");
        String city = scanner.nextLine();

        WeatherAPI weatherAPI = new WeatherAPI();
        WeatherResponseParser parser = new WeatherResponseParser();
        // String city = "London"; // You can change this to any city you want

        try {
            String forecast = weatherAPI.getForecast(city);
            System.out.println("Weather forecast for " + city + ":");
            System.out.println(forecast);
            parser.parseAndPrint(forecast);

        } catch (Exception e) {
            System.err.println("Error fetching weather data: " + e.getMessage());
        }
    }

}
