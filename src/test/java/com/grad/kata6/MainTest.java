package com.grad.kata6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Should add 2 input under one key")
    void test_shouldAdd2InputUnderOneKey() {
        //Given
        Map<Integer, List<Word>> hMap = new HashMap<>();

        //When
        Main.addInputToHasMap("kutya", hMap);
        Main.addInputToHasMap("tyuka", hMap);


        //Then
       assertEquals(1, hMap.size());
    }

    @Test
    @DisplayName("Should add 4 input under two key")
    void test_shouldAdd4InputUnderTwoKey() {
        //Given
        Map<Integer, List<Word>> hMap = new HashMap<>();

        //When
        Main.addInputToHasMap("kutya", hMap);
        Main.addInputToHasMap("caci", hMap);
        Main.addInputToHasMap("tyuka", hMap);
        Main.addInputToHasMap("cica", hMap);

        //Then
        assertEquals(2, hMap.size());
    }

}
