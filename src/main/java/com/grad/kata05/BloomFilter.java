package com.grad.kata05;


public class BloomFilter {

    boolean[] filter;

    public BloomFilter(int number) {
        this.filter = new boolean[number];
    }

    public void add(String word) {
        int newHash = NewHash.createHash(word);
        if (!filter[newHash]) {
            filter[newHash] = true;
        }
    }


    public boolean isContains(String word) {
        return filter[NewHash.createHash(word)];
    }
}
