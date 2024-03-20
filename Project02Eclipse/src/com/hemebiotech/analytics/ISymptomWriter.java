package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data to a source
 * Implementations should handle the output of symptoms
 */
public interface ISymptomWriter {

    /**
     * Writes symptoms to a source.
     * The method will take a map with symptom name and number of occurrences.
     * Implementation should handle formatting and output destination.
     *
     * @param symptoms a map of symptom name as string and number of occurrences as value
     */
    void writeSymptoms(Map<String, Integer> symptoms);

}
