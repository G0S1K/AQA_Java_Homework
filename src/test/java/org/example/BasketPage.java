package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.example.StringModifier.getPriceWithoutCurrency;

public class BasketPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class, 'list-item__wrap')]")
    private List<WebElement> listItems;
    @FindBy(xpath = "//div[@class='b-top__count line']//span[1]")
    private WebElement countProducts;
    @FindBy(xpath = "//div[@class='b-top__count line']//span[2]")
    private WebElement totalPrice;

    public BasketPage() {
        driver.get("https://www.wildberries.ru/lk/basket");
        PageFactory.initElements(driver, this);
    }

    public List<Item> getList() {
        List<Item> mainList = new ArrayList<>();
        try {
            listItems
                    .forEach(item -> {
                        WebElement name = item.findElement(
                                By.xpath(".//span[contains(@class, 'good-info__good-name')]"));
                        WebElement brand = item.findElement(
                                By.xpath(".//span[contains(@class, 'good-info__good-brand')]"));
                        WebElement price = item.findElement(
                                By.xpath(".//div[contains(@class, 'list-item__price-new')]"));
                        mainList.add(new Item(price.getAttribute("innerText"),
                                name.getAttribute("innerText").trim() +
                                        brand.getAttribute("innerText").trim()));
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mainList;
    }

    public int getTotalPrice() {
        return getPriceWithoutCurrency(totalPrice.getAttribute("innerText"));
    }

    public int getTotalCount() {
        return getPriceWithoutCurrency(countProducts.getAttribute("innerText"));
    }
}
