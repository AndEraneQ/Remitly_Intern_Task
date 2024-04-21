package org.example;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {
    public boolean checkIfResourceFieldContainsASingleAsterisk(String pathToFile){
        try {
            // Read the content of the JSON file and convert it to a string.
            String jsonContent = new String(Files.readAllBytes(Paths.get(pathToFile)));
            // Create a JSON object from the string.
            JSONObject data = new JSONObject(jsonContent);
            // // Check if the "Resource" field exists in the JSON
            if (!data.getJSONObject("PolicyDocument")
                    .getJSONArray("Statement")
                    .getJSONObject(0)
                    .has("Resource")) {
                throw new RuntimeException("Field 'Resource' not found in the JSON file.");
            }
            // Get the value of the "Resource" field from our JSON object.
            String resource = data.getJSONObject("PolicyDocument")
                    .getJSONArray("Statement")
                    .getJSONObject(0)
                    .getString("Resource");
            // Check if the "Resource" field equals "*".
            return !resource.equals("*");
        } catch (IOException | JSONException e) {
            // Handle errors related to reading the JSON file or parsing JSON data.
            throw new RuntimeException("Error reading JSON file: " + e.getMessage());
        } catch (Exception e) {
            // Handle unexpected errors.
            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }
    }
}
