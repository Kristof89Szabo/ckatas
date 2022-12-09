package com.grad.kata2;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //http://codekata.com/kata/kata02-karate-chop/
    }


    public static int chop(int searchedNumber, List<Integer> numbers) {
        int left = 0;
        int right = numbers.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (searchedNumber < numbers.get(mid)) {
                right = mid - 1;
            } else if (searchedNumber > numbers.get(mid)) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}


