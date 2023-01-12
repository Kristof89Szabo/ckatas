package com.grad.kata4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Weather {

    public static void main(String[] args) {
        String path = "src/main/resources/weather.dat";
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            skipHeaders(reader);
            Map<Integer, Double> dayData = saveDataToMap(reader);
            Double smallestSpread = findSmallestTempSpread(dayData);
            System.out.println("Day: " + whichDayIsSmallestSpread(dayData, smallestSpread));

        } catch (IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    private static Integer whichDayIsSmallestSpread(Map<Integer, Double> dayData, Double smallestSpread) {

        for (Entry<Integer, Double> e : dayData.entrySet()) {
            if (e.getValue().equals(smallestSpread)) {
                return e.getKey();
            }
        }
        return null;
    }

    private static Double findSmallestTempSpread(Map<Integer, Double> dayData) {
        Set<Double> treeSet = new TreeSet<>();

        for (Entry<Integer, Double> e : dayData.entrySet()) {
            treeSet.add(e.getValue());
        }

        Double[] arr = new Double[treeSet.size()];
        arr = treeSet.toArray(arr);

        return arr[1];
    }

    private static Map<Integer, Double> saveDataToMap(BufferedReader reader) throws IOException {
        Map<Integer, Double> days = new HashMap<>();
        int dayCounter = 1;
        String line;
        while ((line = reader.readLine()) != null) {
            Double dailyMax = clearOutData(line, 4, 8);
            Double dailyMin = clearOutData(line, 8, 14);
            Double tempSpread = calculateTempSpread(dailyMax, dailyMin);
            days.put(dayCounter, tempSpread);
            dayCounter++;
        }
        return days;

    }

    private static double calculateTempSpread(Double dailyMax, Double dailyMin) {
        return dailyMax - dailyMin;
    }

    private static double clearOutData(String line, Integer start, Integer end) {
        return Double.parseDouble(line.substring(start, end).trim().replaceAll("\\D", ""));
    }

    private static void skipHeaders(BufferedReader reader) throws IOException {
        String headers;
        while ((headers = reader.readLine()) != null) {
            if (headers.isBlank()) {
                break;
            }
        }
    }
}
