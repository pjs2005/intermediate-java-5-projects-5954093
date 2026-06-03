#!/usr/bin/env bash
set -e

# Run the WeatherApp with the org.json jar on the classpath.
if [[ ! -f lib/json-20260522.jar ]]; then
  echo "Error: lib/json-20260522.jar not found. Place the jar in lib/ and run again."
  exit 1
fi

java -cp "bin:lib/json-20260522.jar" com.shaunwassell.weather.WeatherApp
