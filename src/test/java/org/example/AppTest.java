package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppTest
{
    private static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement cookieAccept = driver.findElement(
                By.xpath("//button[@class='btn btn_black cookie__ok']"));
        cookieAccept.click();
    }


    @ParameterizedTest
    @CsvSource({
            "pay-connection, phone, Номер телефона",
            "pay-internet, phone, Номер абонента",
            "pay-instalment, score, Номер счета на 44",
            "pay-arrears, score, Номер счета на 2073"
    })
    @Order(1)
    void testCheckPlaceholderOnCommunication(String select, String firstInput, String fistPlaceholder) {
        WebElement phoneInput = driver.findElement(By.cssSelector("form#" + select + ">div>input." + firstInput));
        Assertions.assertEquals(phoneInput.getAttribute("placeholder"), fistPlaceholder,
                "Wrong placeholder");

        WebElement totalInput = driver.findElement(By.cssSelector("form#pay-connection>div>input.total_rub"));
        Assertions.assertEquals(totalInput.getAttribute("placeholder"), "Сумма",
                "Wrong placeholder");

        WebElement emailInput = driver.findElement(By.cssSelector("form#pay-connection>div>input.email"));
        Assertions.assertEquals(emailInput.getAttribute("placeholder"), "E-mail для отправки чека",
                "Wrong placeholder");
    }

    @Test
    @Order(2)
    void testCheckForSystems() {
        WebElement phoneInput = driver.findElement(
                By.xpath("//form[@id='pay-connection']//div//input[@class='phone']"));
        phoneInput.sendKeys("297777777");
        WebElement totalRubInput = driver.findElement(
                By.xpath("//form[@id='pay-connection']//div//input[@class='total_rub']"));
        totalRubInput.sendKeys("10");
        WebElement emailInput = driver.findElement(
                By.xpath("//form[@id='pay-connection']//div//input[@class='email']"));
        emailInput.sendKeys("ko.gl@gmail.com");
        WebElement button = driver.findElement(
                By.xpath("//form[@id='pay-connection']//button"));
        button.click();

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.bepaid-iframe")));
        Assertions.assertEquals("10.00 BYN", driver.findElement(By.cssSelector("p.header__payment-amount"))
                .getAttribute("innerText"));
        Assertions.assertEquals("Оплатить 10.00 BYN", driver.findElement(By.cssSelector("button.colored.disabled.ng-star-inserted"))
                .getAttribute("innerText"));

        Assertions.assertEquals("Оплата: Услуги связи Номер:375297777777", driver.findElement(By.cssSelector("p.header__payment-info"))
                .getAttribute("innerText"));

        WebElement paySystems = driver.findElement(By.cssSelector("div.cards-brands.cards-brands__container"));
        Assertions.assertNotEquals(0, Integer.parseInt(paySystems.getAttribute("childElementCount")));

        WebElement cardNumberInput = driver.findElement(By.cssSelector("label.ng-tns-c47-1.ng-star-inserted"));
        Assertions.assertEquals(cardNumberInput.getAttribute("innerText"), "Номер карты",
                "Wrong placeholder");

        WebElement dateInput = driver.findElement(By.cssSelector("label.ng-tns-c47-4.ng-star-inserted"));
        Assertions.assertEquals(dateInput.getAttribute("innerText"), "Срок действия",
                "Wrong placeholder");

        WebElement cvcInput = driver.findElement(By.cssSelector("label.ng-tns-c47-5.ng-star-inserted"));
        Assertions.assertEquals(cvcInput.getAttribute("innerText"), "CVC",
                "Wrong placeholder");

        WebElement nameInput = driver.findElement(By.cssSelector("label.ng-tns-c47-3.ng-star-inserted"));
        Assertions.assertEquals(nameInput.getAttribute("innerText"), "Имя держателя (как на карте)",
                "Wrong placeholder");

        driver.switchTo().defaultContent();
    }
    @AfterAll
    public static void tearDown(){
        driver.close();
    }
}
