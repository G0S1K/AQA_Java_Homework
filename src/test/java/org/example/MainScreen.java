package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainScreen {
    private final AndroidDriver driver;

    @FindBy(id = "com.google.android.calculator:id/result_final")
    private WebElement result;

    @FindBy(id = "com.google.android.calculator:id/eq")
    private WebElement equals;

    public MainScreen(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MainScreen clickToDigit(String digit) {
        driver.findElement(By.id("com.google.android.calculator:id/digit_" + digit)).click();
        return this;
    }

    public MainScreen clickToOp(String operation) {
        driver.findElement(By.id("com.google.android.calculator:id/op_" + operation)).click();
        return this;
    }

    public MainScreen clickToEquals() {
        equals.click();
        return this;
    }

    public String getResult() {
            return result.getText();
    }




}
