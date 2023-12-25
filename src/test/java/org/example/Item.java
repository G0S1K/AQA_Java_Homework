package org.example;

import static org.example.StringModifier.getPriceWithoutCurrency;

public class Item {
    public String name;
    public int price;

    public Item(String _price, String _name) {
        name = _name;
        price = getPriceWithoutCurrency(_price);
    }


}
