package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
    @Test(description = "Test with negative number", priority = 1)
    void testWithNegativeNumber() {
        Assert.assertThrows(IllegalArgumentException.class, () -> App.factorial(-4));
    }

    @Test(description = "Test with positive numbers", priority = 2)
    void testWithPositiveNumbers() {
        Assert.assertEquals(1, App.factorial(1));
        Assert.assertEquals(1, App.factorial(0));
        Assert.assertEquals(120, App.factorial(5));
        Assert.assertEquals(362880, App.factorial(9));
    }
}
