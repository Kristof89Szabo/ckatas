package com.grad.kata11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingCharactersTest {

    @Test
    @DisplayName("Should Arrange Character And Multiply")
    void test_shouldArrangeCharacterAndMultiply() {
        //Given
        String originalString = "When not studying nuclear physics, Bambi likes to play\n" +
                "beach volleyball.";

        //When
        String result = SortingCharacters.decodeString(originalString);

        //Then
        assertEquals("aaaaabbbbcccdeeeeeghhhiiiiklllllllmnnnnooopprsssstttuuvwyyyy", result);
    }

}
