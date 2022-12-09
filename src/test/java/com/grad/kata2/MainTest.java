package com.grad.kata2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.grad.kata2.Main.chop;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {


    @Test
    void testChopWithEmptyListSearchedNumberIs3() {
        //Given
        int searchedNumber = 3;
        List<Integer> numbers = List.of();
        int expected = -1;
        //When
        int actual = chop(searchedNumber, numbers);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void testChopWithOneElementSearchedNumberIs3() {
        //Given
        int searchedNumber = 3;
        List<Integer> numbers = List.of(1);
        int expected = -1;
        //When
        int actual = chop(searchedNumber, numbers);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void testChopWithOneElementSearchedNumberIs1() {
        //Given
        int expected = 0;
        int searchedNumber = 1;
        List<Integer> numbers = List.of(1);
        //When

        int actual = chop(searchedNumber, numbers);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void testChopWithThreeElementSearchedNumberIs1() {
        //Given
        int expected = 0;
        int searchedNumber = 1;
        List<Integer> numbers = List.of(1, 3, 5);
        //When

        int actual = chop(searchedNumber, numbers);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void testChopWithThreeElementSearchedNumberIs3() {
        //Given
        int expected = 1;
        int searchedNumber = 3;
        List<Integer> numbers = List.of(1, 3, 5);
        //When

        int actual = chop(searchedNumber, numbers);
        //Then
        assertEquals(expected, actual);
    }

    @Test
    void testChopWithThreeElementMultiAssert() {
        //Given
        List<Integer> numbers = List.of(1, 3, 5);
        //When

        //Then
        assertEquals(2, chop(5, numbers));
        assertEquals(-1, chop(0, numbers));
        assertEquals(-1, chop(2, numbers));
        assertEquals(-1, chop(4, numbers));
        assertEquals(-1, chop(6, numbers));
    }

    @Test
    void testChopWithFourElementMultiAssert() {
        //Given
        List<Integer> numbers = List.of(1, 3, 5, 7);
        //When

        //Then
        assertEquals(0, chop(1, numbers));
        assertEquals(1, chop(3, numbers));
        assertEquals(2, chop(5, numbers));
        assertEquals(3, chop(7, numbers));
        assertEquals(-1, chop(0, numbers));
        assertEquals(-1, chop(2, numbers));
        assertEquals(-1, chop(4, numbers));
        assertEquals(-1, chop(6, numbers));
        assertEquals(-1, chop(8, numbers));
    }
}
