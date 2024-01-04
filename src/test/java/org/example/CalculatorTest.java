package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;

public class CalculatorTest{
    private static AndroidDriver driver;
    private static MainScreen mainScreen;

    @BeforeEach
    public void setUp() {
        driver = MobileFactory.getAndroidDriver();
        mainScreen = new MainScreen(driver);
    }

    @Test
    public void checkSum() {
        String result = mainScreen
                .clickToDigit("8")
                .clickToOp("add")
                .clickToDigit("6")
                .clickToEquals()
                .getResult();

        Assertions.assertEquals(result, "14");
    }

    @Test
    public void checkSub() {
        String result = mainScreen
                .clickToDigit("8")
                .clickToOp("sub")
                .clickToDigit("6")
                .clickToEquals()
                .getResult();

        Assertions.assertEquals(result, "2");
    }

    @Test
    public void checkMul() {
        String result = mainScreen
                .clickToDigit("8")
                .clickToOp("mul")
                .clickToDigit("6")
                .clickToEquals()
                .getResult();

        Assertions.assertEquals(result, "48");
    }

    @Test
    public void checkDiv() {
        String result = mainScreen
                .clickToDigit("4")
                .clickToDigit("8")
                .clickToOp("div")
                .clickToDigit("6")
                .clickToEquals()
                .getResult();

        Assertions.assertEquals(result, "8");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
