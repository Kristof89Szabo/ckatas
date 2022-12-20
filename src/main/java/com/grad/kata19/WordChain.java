package com.grad.kata19;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordChain {

    public static void main(String[] args) {

        Path path = Path.of("src/main/java/com/grad/kata19/wordlist.txt");
        List<String> allWord = readFile(path);
        List<String> wordsWithoutSpecialCharacters = pickNormalWords(allWord);
        Map<Integer, List<String>> sepWords = separateWordsByLength(wordsWithoutSpecialCharacters);
        List<String> usedWordsForChain = findWordChains("cat", "dog", sepWords);

    }

    private static List<String> findWordChains(String word1, String word2, Map<Integer, List<String>> words) {
        if (word1.length() != word2.length()) {
            return null;
        }
        //TODO Megcsinalni
        return null;
    }

    private static Map<Integer, List<String>> separateWordsByLength(List<String> wordsWithoutSpecialCharacters) {
        Map<Integer, List<String>> retMap = new HashMap<>();

        for (String word : wordsWithoutSpecialCharacters) {
            List<String> b = retMap.getOrDefault(word.length(), new ArrayList<>());
            b.add(word);
            retMap.put(word.length(), b);
        }
        return retMap;
    }

    private static List<String> pickNormalWords(List<String> allWord) {
        List<String> pickedWords = new ArrayList<>();
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        for (String word : allWord) {
            Matcher m = p.matcher(word);
            if (!m.find() && word.length() > 2) {
                pickedWords.add(word);
            }

        }
        return pickedWords;
    }

    private static List<String> readFile(Path path) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                words.add(line);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }


}
