package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filePath;

    /**
     * @param filePath a full or partial path to file where the symptoms and their value will be written, one per line
     */
    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @param symptoms is a map of symptom name and number of occurrences
     *                 Iterate and write symptom and value to file, one per line in the following format:
     *                 Example: 10
     *                 AnotherExample: 2
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {
            FileWriter writer = new FileWriter(filePath);

            symptoms.forEach((symptom, value) -> {
                try {
                    writer.write(symptom + ": " + value + "\n");
                } catch (IOException e) {
                    System.err.println("An error has occurred: " + e);
                }
            });
            writer.close();

        } catch (IOException e) {
            System.err.println("An error has occurred: " + e);
        }
    }
}
