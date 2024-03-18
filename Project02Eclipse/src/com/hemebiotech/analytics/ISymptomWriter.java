package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data to a source
 *
 */
public interface ISymptomWriter {

    /**
     * The method will use the
     * @param symptoms which is a map of symptom name as string and number of occurrences as value and write it to a source
     *
     */
    public void writeSymptoms(Map<String, Integer> symptoms);

}
