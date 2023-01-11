package com.grad.kata05;

public class NewHash {


    public static int createHash(String word) {
        return Math.abs(word.hashCode() / 144);
    }

}
