package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything the will write symptom data on a valid data output format
 *
 */
public interface ISymptomWriter {

    /**
     * If no data is available, nothing is written
     * 
     * @param symptoms a raw mapping of all Symptoms obtained from a data source, duplicates are allowed.
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
