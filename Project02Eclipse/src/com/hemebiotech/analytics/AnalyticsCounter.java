package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Reads a list of symptoms from a file
     *
     * @return List of symptoms as strings
     */
    public List<String> getSymptoms() {
        return reader.GetSymptoms();
    }

    /**
     * Iterate over a list of symptoms and count the number of occurrences of the symptom in the list
     *
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
     * @return a treemap which is sorted in natural order
     */
    public Map<String,Integer> sortSymptoms(Map<String,Integer> symptoms){
        return new TreeMap<>(symptoms);
    }

    /**
     * Write symptoms to file
     * @param symptoms list of symptoms and their occurrences
     */
    public void writeSymptoms(Map<String, Integer> symptoms){
        writer.writeSymptoms(symptoms);
    }
}
