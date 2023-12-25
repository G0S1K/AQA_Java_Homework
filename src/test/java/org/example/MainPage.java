package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage{
    public MainPage() {
        driver.get("https://www.wildberries.ru/");
    }

    public Item addProduct(int index) {
        WebElement item = driver.findElement(By.xpath("//article[" + index + "]"));
        new Actions(driver).moveToElement(item).perform();
        WebElement itemButton = item.findElement(
                By.xpath(".//a[contains(@class, 'product-card__add-basket')]"));
        itemButton.click();

        String price = item.findElement(By.xpath(".//ins[@class = 'price__lower-price']"))
                .getAttribute("innerText");
        String brand = item.findElement(By.xpath(".//span[@class = 'product-card__brand']"))
                .getAttribute("innerText");
        String name = item.findElement(By.xpath(".//span[@class = 'product-card__name']"))
                .getAttribute("innerText").substring(2);

        if (existsElement(".//div[contains(@class, 'popup-list-of-sizes')]")) {
            driver.findElement(By.xpath(".//ul[@class='sizes-list j-quick-order-sizes']//li[1]"))
                    .click();
        }

        return new Item(price, name.trim() + ", " + brand.trim());
    }

    private boolean existsElement(String xpath) {
        try {
            driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
