package org.example;

public class Main {
    public static void main(String[] args) {
        JsonReader jsonReader = new JsonReader();
        System.out.println(jsonReader.checkIfResourceFieldContainsASingleAsterisk("src/main/resources/SampleJsonFile.json"));
    }
}