package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
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
    @DisplayName("Check sum with two numbers")
    @Description("In this test method calculator click on two numbers and check addition result")
    @Owner("Korotkevich Gleb")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Check subtraction with two numbers")
    @Description("In this test method calculator click on two numbers and check subtraction result")
    @Owner("Korotkevich Gleb")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Check multiplication with two numbers")
    @Description("In this test method calculator click on two numbers and check multiplication result")
    @Owner("Korotkevich Gleb")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Check division with two numbers")
    @Description("In this test method calculator click on two numbers and check division result")
    @Owner("Korotkevich Gleb")
    @Severity(SeverityLevel.NORMAL)
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
