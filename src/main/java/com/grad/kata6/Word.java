package com.grad.kata6;

import java.util.Arrays;

public class Word {

    String wordStr;

    public Word(String wordStr) {
        this.wordStr = wordStr;
    }


    @Override
    public String toString() {
        return wordStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Word)) {
            return false;
        }
        Word anagram = (Word) o;
        return anagram.hashCode() == hashCode();
    }


    @Override
    public int hashCode() {
        char[] tempArray = wordStr.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray).hashCode();
    }
}
