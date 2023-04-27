package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filepath;

    public WriteSymptomDataToFile() {
        this.filepath = "result.out";
    }

  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {

    if (filepath == null) return;

    Map<String, Integer> map = symptoms;

    try {
        FileWriter writer = new FileWriter(filepath);

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> symptom = iterator.next();
            String key = symptom.getKey();
            Integer value = symptom.getValue();
            writer.write(key + " : " + value + "\n");
        }

        writer.close();
    } catch (IOException ex) {
        ex.printStackTrace();
        }
    }
}