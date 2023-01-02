package com.grad.kata19;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordChain {

    public static void main(String[] args) throws IOException {
        String firstWord = "cat";
        String secondWord = "dog";
        //        String firstWord = "lead";
        //        String secondWord = "gold";
        //        String firstWord = "ruby";
        //        String secondWord = "code";


        Path path = Path.of("src/main/java/com/grad/kata19/wordlist.txt");
        Set<String> allWord = readFile(path);
        Map<Integer, List<String>> sepWords = separateWordsByLength(allWord);
        List<String> usedWordsForChain = findWordChains(firstWord, secondWord, sepWords);
        System.out.println(usedWordsForChain);
    }

    private static List<String> findWordChains(String firstWord, String lastWord, Map<Integer, List<String>> allWord) {
        List<String> dictionary = allWord.get(firstWord.length());
        List<String> wordChain = new ArrayList<>();
        wordChain.add(firstWord);
        String checkingWord = firstWord;
        boolean canFind = true;
        while (canFind) {
            String prev = checkingWord;
            for (String currentWord : dictionary) {
                int otherLetter = 0;
                int sameLetter = 0;

                for (int i = 0; i < checkingWord.length(); i++) {
                    if (currentWord.charAt(i) != checkingWord.charAt(i) && currentWord.charAt(i) == lastWord.charAt(i)) {
                        otherLetter++;
                    }
                    if (checkingWord.charAt(i) == currentWord.charAt(i)) {
                        sameLetter++;
                    }
                }
                if (otherLetter == 1 && sameLetter == checkingWord.length() - 1) {
                    checkingWord = currentWord;
                    wordChain.add(checkingWord);
                }
            }
            canFind = !prev.equals(checkingWord);
        }
        return wordChain;
    }

    private static Map<Integer, List<String>> separateWordsByLength(Set<String> words) {
        Map<Integer, List<String>> retMap = new HashMap<>();
        for (String word : words) {
            List<String> b = retMap.getOrDefault(word.length(), new ArrayList<>());
            b.add(word);
            retMap.put(word.length(), b);
        }
        return retMap;
    }

    private static Set<String> readFile(Path path) {
        Set<String> words = new HashSet<>();
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1)) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }


}
