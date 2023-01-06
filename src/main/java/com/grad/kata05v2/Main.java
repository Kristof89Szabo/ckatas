package com.grad.kata05v2;


public class Main {


    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter(2047483647);
        int arrSize = 2047483647;
        String[] sarray = new String[]{"abound", "abounds", "abundance",
                "abundant", "accessible", "bloom",
                "blossom", "bolster", "bonny",
                "bonus", "bonuses", "coherent",
                "cohesive", "colorful", "comely",
                "comfort", "gems", "generosity",
                "generous", "generously", "genial",
                "bluff", "cheater", "hate",
                "war", "humanity", "racism",
                "hurt", "nuke", "gloomy",
                "facebook", "geeksforgeeks", "twitter"};
        for (int i = 0; i < 33; i++) {
            bloomFilter.insert(arrSize, sarray[i]);
        }

        System.out.println(bloomFilter.lookup(2047483647, "bloom"));
        System.out.println(bloomFilter.lookup(2047483647, "eltöredezettségmentesítőtleníttethetetlenségtelenítőtlenkedhetnétek"));

    }

}
