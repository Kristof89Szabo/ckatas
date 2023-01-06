package com.grad.kata05v2;

public class NewHashes {

    public static int h1(String s, int arrSize) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash + s.charAt(i));
            hash = hash % arrSize;
        }
        return Math.abs(hash);
    }

    public static int h2(String s, int arrSize) {
        int hash = 1;
        for (int i = 0; i < s.length(); i++) {
            hash = (int) (hash + Math.pow(19, i) * s.charAt(i));
            hash = hash % arrSize;
        }
        return Math.abs(hash) % arrSize;
    }

    public static int h3(String s, int arrSize) {
        int hash = 7;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash * 31 + s.charAt(i)) % arrSize;
        }
        return Math.abs(hash) % arrSize;
    }
}
