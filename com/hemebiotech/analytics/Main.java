package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Read symptoms from file, count them, sort them and write them to file
        final ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        final ISymptomWriter writer = new WriteSymptomDataToFile();

        final AnalyticsCounter analytics = new AnalyticsCounter(reader, writer);

        final List<String> symptoms = analytics.getSymptoms();
        final Map<String, Integer> count = analytics.countSymptoms(symptoms);
        final Map<String, Integer> sort = analytics.sortSymptoms(count);

        analytics.writeSymptoms(sort);
    }
}