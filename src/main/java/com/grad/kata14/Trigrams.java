package com.grad.kata14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
http://codekata.com/kata/kata14-tom-swift-under-the-milkwood/

What is tigrams? https://youtu.be/GBQFelgzjKQ

 */

public class Trigrams {

    public static void main(String[] args) {
        //        String originalSentence = "I wish I may I wish I might";
        String originalSentence = "Egy kutya setal a parkban. Egy kutya szalad egy bot utan a parkban.";

        String[] strArr = originalSentence.split(" ");

        Map<String, List<String>> hMap = new HashMap<>();

        for (int i = 0; i < strArr.length - 2; i++) {
            String temp = strArr[i] + strArr[i + 1];
            List<String> alterWords = new ArrayList<>();
            for (int j = i + 1; j < strArr.length - 1; j++) {
                if (!hMap.containsKey(temp) && (strArr[j - 1] + strArr[j]).equals(temp)) {
                    alterWords.add(strArr[j + 1]);
                }
            }
            hMap.putIfAbsent(temp, alterWords);
        }

        System.out.println(hMap);
    }

}
