package com.grad.kata11;

import java.util.HashMap;
import java.util.Map;

public class SortingCharacters {


    public static void main(String[] args) {
        String originalString = "When not studying nuclear physics, Bambi likes to play\n" +
                "beach volleyball.";
        System.out.println(decodeString(originalString));
    }

    public static String decodeString(String originalString) {
        String removedWhitespaces = sanitizeOriginalString(originalString);
        Map<Character, Integer> ascii = countEachCharacterFromString(removedWhitespaces);
        return sortCountedCharacter(ascii);
    }

    private static String sanitizeOriginalString(String originalString) {
        return originalString.toLowerCase().replaceAll("[,.\\s]", "");
    }

    private static String sortCountedCharacter(Map<Character, Integer> ascii) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> c : ascii.entrySet()) {
            builder.append(String.valueOf(c.getKey()).repeat(c.getValue()));
        }
        return builder.toString();
    }

    private static Map<Character, Integer> countEachCharacterFromString(String sanitizedSentence) {
        Map<Character, Integer> ascii = new HashMap<>();
        for (int i = 0; i < sanitizedSentence.length(); i++) {
            Character character = sanitizedSentence.charAt(i);
            if (!ascii.containsKey(character)) {
                ascii.put(character, 1);
            } else {
                Integer num = ascii.get(character);
                ascii.put(character, ++num);
            }
        }
        return ascii;
    }
}
