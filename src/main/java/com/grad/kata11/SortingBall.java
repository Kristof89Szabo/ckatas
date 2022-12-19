package com.grad.kata11;

import java.util.ArrayList;
import java.util.List;

public class SortingBall {

    public static void main(String[] args) {
        //Bubble Sort
        List<Integer> list = new ArrayList<>();

        addNumber(list, 5);
        addNumber(list, 4);
        addNumber(list, 3);

    }

    public static void addNumber(List<Integer> list, int number) {
        list.add(number);
        sortList(list);
    }

    private static void sortList(List<Integer> list) {

        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        System.out.println();
        for (Integer integer : list) {
            System.out.print(integer + " ");
            System.out.println();
        }
    }


}
