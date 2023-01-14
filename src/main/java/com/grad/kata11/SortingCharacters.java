package com.grad.kata11;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class SortingCharacters {


    public static void main(String[] args) {
        String originalString = "When not studying nuclear physics, Bambi likes to play\n" +
                "beach volleyball.";
        System.out.println(decodeString(originalString));
    }

    public static String decodeString(String originalString) {
        String removedWhitespaces = sanitizeOriginalString(originalString);
        Map<Character, List<Character>> ascii = countEachCharacterFromString(removedWhitespaces);
        return sortCountedCharacter(ascii);
    }

    private static String sanitizeOriginalString(String originalString) {
        return originalString.toLowerCase().replaceAll("[,.\\s]", "");
    }

    private static String sortCountedCharacter(Map<Character, List<Character>> ascii) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, List<Character>> c : ascii.entrySet()) {
            builder.append(String.valueOf(c.getKey()).repeat(c.getValue().size()));
        }
        return builder.toString();
    }

    private static Map<Character, List<Character>> countEachCharacterFromString(String sanitizedSentence) {
        return sanitizedSentence.chars().mapToObj(c -> (char) c)
                .collect(groupingBy(character -> character));

    }
}
