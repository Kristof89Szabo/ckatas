package com.grad.kata6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    static Map<String, List<String>> anagramMap = new HashMap<>();

    public static void main(String[] args) {
        String path = "codekata/src/main/resources/wordlist.txt";
        List<String> wholeFileData = readFile(path);
        addInputToHasMap(wholeFileData, anagramMap);
        writeOutHashMapValues();
    }

    public static List<String> readFile(String path) {
        List<String> lines = new ArrayList<>();
        Path currentPath = Path.of(path);
        try (Stream<String> readLine = Files.lines(currentPath, StandardCharsets.ISO_8859_1)) {
            readLine.forEach(lines::add);
        } catch (IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        return lines;
    }

    static void addInputToHasMap(List<String> wholeFileData, Map<String, List<String>> anagramMap) {
        for (String line : wholeFileData) {

            String keySortedWord = getWordLettersSorted(line);
            if (!anagramMap.containsKey(keySortedWord)) {
                anagramMap.put(keySortedWord, new ArrayList<>(List.of(line)));
            } else {
                anagramMap.get(keySortedWord).add(line);
            }
        }
    }

    private static String getWordLettersSorted(String word) {
        char[] tempArray = word.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    private static void writeOutHashMapValues() {
        int rowCounter = 1;
        for (Map.Entry<String, List<String>> h : anagramMap.entrySet()) {
            if (h.getValue().size() > 1) {
                System.out.print(rowCounter + " " + h.getValue() + "\n");
                rowCounter++;
            }

        }
    }

}
