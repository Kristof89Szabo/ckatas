package com.grad.kata18;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    /*
http://codekata.com/kata/kata18-transitive-dependencies/
     */


    public static void main(String[] args) {
//        Path path = Path.of("src/main/resources/input");
        Path path = Path.of("src/main/resources/input2");
        Map<String, List<String>> data = readSourceFromFile(path);
        collectDependencies(data);

        System.out.println(sanitizeValues(data));

    }

    private static Map<String, Set<String>> sanitizeValues(Map<String, List<String>> data) {
        Map<String, Set<String>> retSolution = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : data.entrySet()) {
            retSolution.put(entry.getKey(), new TreeSet<>(entry.getValue()));
        }
        return retSolution;
    }

    private static void collectDependencies(Map<String, List<String>> data) {
        for (Map.Entry<String, List<String>> entry : data.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                List<String> checkingList = entry.getValue();
                String elem = checkingList.get(i);
                if (data.containsKey(elem)) {
                    checkingList.addAll(data.get(elem));
                }
            }
        }
    }

    private static Map<String, List<String>> readSourceFromFile(Path path) {
        Map<String, List<String>> hMap = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(" ");
                String[] valueArray = new String[array.length - 1];
                System.arraycopy(array, 1, valueArray, 0, array.length - 1);
                hMap.put(array[0], new ArrayList<>(Arrays.asList(valueArray)));
            }
            return hMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hMap;
    }

}
