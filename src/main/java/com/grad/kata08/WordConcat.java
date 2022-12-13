package com.grad.kata08;

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
import java.util.concurrent.TimeUnit;

public class WordConcat {


    public static void main(String[] args) {
        List<String> sixLengthWords = new ArrayList<>();
        List<String> otherLengthWords = new ArrayList<>();
        String path = "src/main/resources/wordlist.txt";

        uploadHashMapWithSixSizeKeysListWithOthers(path, sixLengthWords, otherLengthWords);
        Map<String, String[]> hmap = findConcatWords(sixLengthWords, otherLengthWords);

        for (Map.Entry<String, String[]> entry : hmap.entrySet()){
            System.out.println("Original word: " + entry.getKey() + " 2 words: " + Arrays.toString(entry.getValue()));
        }
    }

    private static Map<String, String[]> findConcatWords(List<String> sixLengthWords, List<String> otherLengthWords) {
        long start = System.currentTimeMillis();
        Map<String, String[]> hMap = new HashMap<>();
        for (int i = 0; i < sixLengthWords.size(); i++) {
            String checkingWord = sixLengthWords.get(i);
            for (int j = 1; j < checkingWord.length(); j++) {
                String firstPart = checkingWord.substring(0, j);
                String secondPart = checkingWord.substring(j);
                if (otherLengthWords.contains(firstPart) && otherLengthWords.contains(secondPart)) {
                    hMap.put(checkingWord, new String[]{firstPart, secondPart});
                }
            }


        }
        long end = (System.currentTimeMillis() - start);
        System.out.println("Took: " + TimeUnit.MILLISECONDS.toSeconds(end));
        return hMap;
    }

    private static void uploadHashMapWithSixSizeKeysListWithOthers(String path, List<String> sixLengthWords, List<String> otherLengthWords) {

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path), StandardCharsets.ISO_8859_1)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String sanStr = line.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                if (sanStr.length() == 6) {
                    sixLengthWords.add(sanStr);
                } else {
                    otherLengthWords.add(sanStr);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
