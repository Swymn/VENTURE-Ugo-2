package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    // The filepath to write the data to
    private final String filepath;

    /**
     * Default constructor, initialize filepath to "result.out".
     */
    public WriteSymptomDataToFile() {
        this.filepath = "result.out";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        // If no data is available, return
        if (filepath == null)
            return;

        // Use try-with-resources to close the file automatically
        try (FileWriter writer = new FileWriter(filepath)) {
            final Iterator<Map.Entry<String, Integer>> iterator = symptoms.entrySet().iterator();

            // Write each symptom and its count on a new line
            while (iterator.hasNext()) {
                final Map.Entry<String, Integer> symptom = iterator.next();
                final String key = symptom.getKey();
                final Integer value = symptom.getValue();
                writer.write(key + " : " + value + "\n");
            }

        } catch (IOException ex) {
            // Print the stack trace if an error occurs
            ex.printStackTrace();
        }
    }
}