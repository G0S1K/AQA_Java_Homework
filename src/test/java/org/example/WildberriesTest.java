package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WildberriesTest extends BaseTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    public void test(int countProducts) throws InterruptedException {
        MainPage mainPage = new MainPage();
        List<Item> mainList = new ArrayList<>();

        for (int i = 1; i <= countProducts; i++) {
            mainList.add(mainPage.addProduct(i));
        }

        Collections.reverse(mainList);

        BasketPage basketPage = new BasketPage();
        Thread.sleep(2000);
        List<Item> basketList = basketPage.getList();

        for (int i = 0; i < countProducts; i++) {
            Assertions.assertEquals(mainList.get(i).name, basketList.get(i).name);
            Assertions.assertEquals(mainList.get(i).price, basketList.get(i).price);
        }

        Assertions.assertEquals(mainList.size(), basketPage.getTotalCount());

        Assertions.assertEquals(mainList.stream().mapToInt(item -> item.price).sum(), basketPage.getTotalPrice());

    }
}
