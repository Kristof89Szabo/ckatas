package com.grad.kata6;

import java.util.Arrays;
import java.util.Objects;

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(wordStr, word.wordStr);
    }

        @Override
        public int hashCode() {
            char[] tempArray = wordStr.toCharArray();
            Arrays.sort(tempArray);
            return new String(tempArray).hashCode();
        }
}
