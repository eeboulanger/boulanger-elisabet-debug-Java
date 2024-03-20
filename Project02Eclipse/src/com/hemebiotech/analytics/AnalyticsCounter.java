package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Manages the processing of symptom data
 *
 */
public class AnalyticsCounter {

    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Retrieves a list of symptoms
     * @return List of symptoms as strings
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /**
     * Counts the number of occurrences for each symptom in a list
     * @param symptoms is a list of symptoms as strings
     * @return a map with symptom and the number of occurrences
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {

        Map<String, Integer> countedSymptoms = new HashMap<>();

        symptoms.forEach((symptom) -> countedSymptoms.put(symptom, countedSymptoms.getOrDefault(symptom, 0) + 1));
        return countedSymptoms;
    }

    /**
     * Sort symptoms in alphabetic order
     * @param symptoms is a map of symptoms and their occurrences
     * @return a map of symptoms sorted by name
     */
    public Map<String,Integer> sortSymptoms(Map<String,Integer> symptoms){
        return new TreeMap<>(symptoms);
    }

    /**
     * Write symptoms to file
     * @param symptoms a map of symptoms and their occurrences
     */
    public void writeSymptoms(Map<String, Integer> symptoms){
        writer.writeSymptoms(symptoms);
    }
}
