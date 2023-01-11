package com.grad.kata05v2;


import static com.grad.kata05v2.NewHashes.h1;
import static com.grad.kata05v2.NewHashes.h2;
import static com.grad.kata05v2.NewHashes.h3;

public class BloomFilter {



    boolean[] filter;

    public BloomFilter(int number) {
        this.filter = new boolean[number];
    }
    boolean lookup(int arrSize, String s) {
        int a = h1(s, arrSize);
        int b = h2(s, arrSize);
        int c = h3(s, arrSize);

        return filter[a] && filter[b] && filter[c];
    }




    public void insert(int arrSize, String s) {
        if (lookup(arrSize, s))
            System.out.println(s + " is Probably already present");
        else {
            int a = h1(s, arrSize);
            int b = h2(s, arrSize);
            int c = h3(s, arrSize);


            filter[a] = true;
            filter[b] = true;
            filter[c] = true;


            System.out.println(s + " inserted");
        }
    }
}
