package com.grad.kata08;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class WordConcat {


    public static void main(String[] args) {
        String path = "src/main/resources/wordlist.txt";

        List<String> allLines = readFile(path);
        Map<Integer, List<String>> separatedWordsByLength = separateWordsByLength(allLines);

        Map<String, String[]> collectedSixLengthWordWithSubWords = findConcatWords(separatedWordsByLength);
        System.out.println("Map size: " + collectedSixLengthWordWithSubWords.size());
    }

    private static Map<String, String[]> findConcatWords(Map<Integer, List<String>> allSeparatedWords) {
        List<String> otherLengthWords = collectOtherLengthWordsThanSix(allSeparatedWords);

        Map<String, String[]> originalWordWithSubWords = new HashMap<>();

        for (String checkingWord : allSeparatedWords.get(6)) {
            addWordToCollectionIfThereSubWordConcat(otherLengthWords, originalWordWithSubWords, checkingWord);
        }

        return originalWordWithSubWords;
    }

    private static List<String> collectOtherLengthWordsThanSix(Map<Integer, List<String>> allSeparatedWords) {
        List<String> otherWords = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : allSeparatedWords.entrySet()) {
            if (entry.getKey() != 6) {
                otherWords.addAll(entry.getValue());
            }
        }
        return otherWords;
    }

    private static void addWordToCollectionIfThereSubWordConcat(List<String> otherLengthWords, Map<String, String[]> originalWordWithSubWords, String checkingWord) {
        for (int j = 1; j < checkingWord.length(); j++) {
            Word word = new Word(checkingWord.substring(0, j), checkingWord.substring(j));
            if (otherLengthWords.contains(word.firstPart) && otherLengthWords.contains(word.secondPart)) {
                originalWordWithSubWords.put(checkingWord, new String[]{word.firstPart, word.secondPart});
                break;
            }
        }
    }

    private static List<String> readFile(String path) {

        List<String> collectedLines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path), StandardCharsets.ISO_8859_1)) {
            String line;
            while ((line = reader.readLine()) != null) {
                collectedLines.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return collectedLines;
    }

    private static Map<Integer, List<String>> separateWordsByLength(List<String> lines) {
        return lines.stream()
                .map(WordConcat::sanitizeCurrentWord)
                .collect(groupingBy(String::length));
    }

    private static String sanitizeCurrentWord(String word) {
        return word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

}
