package org.example;

import java.util.stream.Collectors;

public class StringModifier {
    public static int getPriceWithoutCurrency(String string) {
        return Integer.parseInt(string.chars()
                .filter(Character::isDigit)
                .mapToObj(Character::toString)
                .collect(Collectors.joining()));
    }
}
