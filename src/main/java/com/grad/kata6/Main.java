package com.grad.kata6;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<Integer, List<Word>> anagramMap = new HashMap<>();

    public static void main(String[] args) {
        String path = "src/main/resources/wordlist.txt";
        readFile(path, anagramMap);
        writeOutHashMapValues();
    }

    public static void readFile(String path, Map<Integer, List<Word>> anagramMap) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path), StandardCharsets.ISO_8859_1)) {
            String line;
            while ((line = reader.readLine()) != null) {
                addInputToHasMap(line, anagramMap);
            }
        } catch (IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    static void addInputToHasMap(String input, Map<Integer, List<Word>> anagramMap) {
        Word w = new Word(input);
        Integer hashCode = w.hashCode();
        if (!anagramMap.containsKey(hashCode)) {
            anagramMap.put(hashCode, new ArrayList<>(List.of(w)));
        } else {
            anagramMap.get(hashCode).add(new Word(input.toLowerCase()));
        }
    }

    private static void writeOutHashMapValues() {
        int rowCounter = 1;
        for (Map.Entry<Integer, List<Word>> h : anagramMap.entrySet()) {
            if (h.getValue().size() > 1) {
                System.out.print(rowCounter + " " + h.getValue() + "\n");
                rowCounter++;
            }

        }
    }

}
