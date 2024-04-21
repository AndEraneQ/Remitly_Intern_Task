package org.example;

public class Main {
    public static void main(String[] args) {
        JsonReader jsonReader = new JsonReader();
        boolean result = jsonReader.checkIfResourceFieldContainsASingleAsterisk("src/main/resources/SampleJsonFile.json");
        System.out.println("Result : " + result + " (false - there is a single asterisk, true - there is something diffrent" );
    }
}