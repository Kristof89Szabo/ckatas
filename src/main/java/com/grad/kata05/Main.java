package com.grad.kata05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter(2047483647);
        List<String> words = readFile();
        uploadFilter(bloomFilter, words);
        System.out.println(bloomFilter.isContains("ABA"));
        System.out.println(bloomFilter.isContains("eltöredezettségmentesítőtleníttethetetlenségtelenítőtlenkedhetnétek"));
    }

    private static void uploadFilter(BloomFilter filter, List<String> words) {
        for (String word : words) {
            filter.add(word);
        }
    }

    private static List<String> readFile() {
        try (Stream<String> reader = Files.lines(Path.of("src/main/resources/wordlist.txt"), StandardCharsets.ISO_8859_1)) {
            return reader.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
