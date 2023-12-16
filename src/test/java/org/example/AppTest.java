package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
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
    };
    @Test
    @Order(1)
    void testNameOfBlock() {
        WebElement nameOfBlock = driver.findElement(By.xpath("//div[@class='pay__wrapper']//h2"));
        Assertions.assertEquals(nameOfBlock.getAttribute("textContent"), "Онлайн пополнение без комиссии",
                "Name is empty");
    }

    @Test
    @Order(2)
    void testCheckForSystems() {
        WebElement paySystems = driver.findElement(By.xpath("//div[@class='pay__partners']//ul"));
        Assertions.assertNotEquals(0, Integer.parseInt(paySystems.getAttribute("childElementCount")),
                "There are no paysystems.");
    }

    @Test
    @Order(3)
    void testLink() {
        WebElement link = driver.findElement(By.xpath("//div[@class='pay__wrapper']//a"));
        link.click();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl(), "This is wrong link");
    }

    @Test
    @Order(4)
    void testForm() throws InterruptedException {
        driver.get("https://www.mts.by/");
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
    }

    @AfterAll
    public static void tearDown(){
        driver.close();
    }
}
