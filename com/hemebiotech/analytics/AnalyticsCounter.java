package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
    private final ISymptomReader reader;
    private final ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> map = new HashMap<>();
        for (String symptom : symptoms) {
            if (map.containsKey(symptom)) {
                map.put(symptom, (map.get(symptom) + 1));
            } else {
                map.put(symptom, 1);
            }
        }
        return map;
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
}