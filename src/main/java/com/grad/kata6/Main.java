package com.grad.kata6;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer, List<Word>> anagramMap = new HashMap<>();
        String path = "src/main/resources/wordlist.txt";
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path), StandardCharsets.ISO_8859_1)) {
            String line;
            while ((line = reader.readLine()) != null) {

                Word w = new Word(line);
                Integer hashCode = w.hashCode();
                if (!anagramMap.containsKey(hashCode)) {
                    anagramMap.put(hashCode, new ArrayList<>(List.of(w)));
                } else {

                    anagramMap.get(hashCode).add(new Word(line.toLowerCase()));
                }
            }
        } catch (IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        int rowCounter = 1;
        for (Map.Entry<Integer, List<Word>> h : anagramMap.entrySet()) {
            if (h.getValue().size() > 1) {
                System.out.print(rowCounter + " " + h.getValue() + "\n");
                rowCounter++;
            }

        }
    }

}
