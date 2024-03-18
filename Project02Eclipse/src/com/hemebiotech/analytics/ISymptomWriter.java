package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data to a source
 * The important part is the value that is used in the operation, which is a map of strings with corresponding int as value
 *
 */
public interface ISymptomWriter {

    public void writeSymptoms(Map<String, Integer> symptoms);

}
