package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String args[]) {
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile();

        AnalyticsCounter analytics = new AnalyticsCounter(reader, writer);

        List<String> symptoms = analytics.getSymptoms();
        Map<String, Integer> count = analytics.countSymptoms(symptoms);
        Map<String, Integer> sort = analytics.sortSymptoms(count);

        analytics.writeSymptoms(sort);
    }
}