package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    private ISymptomReader reader;
    private ISymptomWriter writer;

    private Map<String, Integer> countedSymptoms;
    private List<String> symptoms;
    private static int headacheCount;
    private static int rashCount;
    private static int pupilCount;

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
        symptoms = reader.GetSymptoms();
        return symptoms;
    }

    /**
     * Iterate over a list of symptoms and count the number of occurrences of the symptom in the list
     *
     * @param symptoms is a list of symptoms as strings
     * @return a map with symptom and the number of occurrences
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {

        countedSymptoms = new HashMap<>();

        symptoms.forEach((symptom) -> {
            countedSymptoms.put(symptom, countedSymptoms.getOrDefault(symptom, 0) + 1);
        });
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
     * @param symptoms
     */
    public void writeSymptoms(Map<String, Integer> symptoms){
        writer.writeSymptoms(symptoms);
    }

    public static void main(String args[]) throws Exception {
        // first get input
        BufferedReader reader = new BufferedReader(new FileReader
                ("symptoms.txt"));
        String line = reader.readLine();

        int tempHeadCount = 0;
        int tempRashCount = 0;
        int tempPupilCount = 0;

        while (line != null) {

            System.out.println("symptom from file: " + line);
            if (line.equals("headache")) {
                tempHeadCount++;
                System.out.println("number of headaches: " + tempHeadCount);
            } else if (line.equals("rash")) {
                tempRashCount++;
            } else if (line.contains("dialated pupils")) {
                tempPupilCount++;
            }

            line = reader.readLine();    // get another symptom
        }


        headacheCount = tempHeadCount;
        rashCount = tempRashCount;
        pupilCount = tempPupilCount;

        // next generate output
        FileWriter writer = new FileWriter("result.out");
        writer.write("headache: " + headacheCount + "\n");
        writer.write("rash: " + rashCount + "\n");
        writer.write("dialated pupils: " + pupilCount + "\n");
        writer.close();
    }
}
