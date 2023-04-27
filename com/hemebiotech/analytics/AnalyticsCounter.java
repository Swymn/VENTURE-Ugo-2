package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    /**
     * Default constructor, initialize reader and writer with the given parameters.
     * @param reader
     *          The reader to use to read the symptoms.
     * @param writer
     *          The writer to use to write the symptoms.
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Get the symptoms from the reader.
     * 
     * @return a list of symptoms.
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /**
     * Count the number of occurrences of each symptom.
     * 
     * @param symptoms 
     *          The list of symptoms to count.
     * @return a map of symptoms and their number of occurrences.
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        final Map<String, Integer> map = new HashMap<>();
        for (final String symptom : symptoms) {
            if (map.containsKey(symptom)) {
                map.put(symptom, (map.get(symptom) + 1));
            } else {
                map.put(symptom, 1);
            }
        }
        return map;
    }

    /**
     * Sort the symptoms alphabetically.
     * 
     * @param symptoms
     *          The map of symptoms to sort.
     * @return a map of symptoms sorted alphabetically.
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        // TreeMap is a sorted map, so it will sort the symptoms alphabetically.
        return new TreeMap<>(symptoms);
    }

    /**
     * Write the symptoms with the writer.
     * 
     * @param symptoms
     *          The map of symptoms to write.
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
}