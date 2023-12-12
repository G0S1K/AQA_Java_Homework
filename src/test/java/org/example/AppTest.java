package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    @DisplayName("Test with negative number")
    void testWithNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> App.factorial(-4), "Number must be positive");
    }

    @Test
    @DisplayName("Test with positive numbers")
    void testWithPositiveNumbers() {
        assertEquals(1,App.factorial(1));
        assertEquals(1,App.factorial(0));
        assertEquals(120,App.factorial(5));
        assertEquals(362880,App.factorial(9));
    }


}
