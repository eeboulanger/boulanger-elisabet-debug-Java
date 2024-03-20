package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Writes symptom data to a file, each symptom name and number of occurrences on a new line
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filePath;

    /**
     * Initialize to write to a specific file path
     * @param filePath a full or partial path to file where the symptoms will be written
     */
    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Writes symptom name and number of occurences to a file
     * @param symptoms is a map of symptom names as keys and number of occurrences as values
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        if (filePath != null) {
            try {
                FileWriter writer = new FileWriter(filePath);

                for(Map.Entry<String, Integer>  entry : symptoms.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
                }
                writer.close();

            } catch (IOException e) {
                System.err.println("An error has occurred: " + e.getMessage());
            }
        }
    }
}
