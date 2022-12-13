package com.grad.kata11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortingBallTest {

    @Test
    @DisplayName("Should add number to list")
    void test_shouldAddNumberToList() {
        //Given
        List<Integer> numberList = new ArrayList<>();
        //When
        SortingBall.addNumber(numberList, 5);
        //Then
        assertEquals(1, numberList.size());
    }

    @Test
    @DisplayName("Should add two number to list and sort it")
    void test_shouldAddTwoNumberToListAndSortIt() {
        //Given
        List<Integer> numberList = new ArrayList<>();


        //When
        SortingBall.addNumber(numberList, 5);
        SortingBall.addNumber(numberList, 4);

        //Then
        assertEquals(2, numberList.size());
        assertEquals(4, numberList.get(0));
        assertEquals(5, numberList.get(1));
    }

    @Test
    @DisplayName("Should add tree number to list and sort it")
    void test_shouldAddThreeNumberToListAndSortIt() {
        //Given
        List<Integer> numberList = new ArrayList<>();


        //When
        SortingBall.addNumber(numberList, 9);
        SortingBall.addNumber(numberList, 7);
        SortingBall.addNumber(numberList, 5);

        //Then
        assertEquals(3, numberList.size());
        assertEquals(5, numberList.get(0));
        assertEquals(7, numberList.get(1));
        assertEquals(9, numberList.get(2));
    }


}
