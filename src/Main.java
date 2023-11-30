import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[] {"apple", "watermelon", "cherry", "strawberry", "grape",
                "kiwi", "lemon", "orange", "orange", "orange", "kiwi", "strawberry", "watermelon"};

        Map<String, Integer> arrayWithoutDuplicates = getArrayWithoutDuplicates(array);

        System.out.println(arrayWithoutDuplicates);

        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        telephoneDirectory.add("Korotkevich", "+375449877634");
        telephoneDirectory.add("Abdul", "+375449874207");
        telephoneDirectory.add("Korotkevich", "+375449600634");
        telephoneDirectory.add("Lolish", "+375449804384");
        telephoneDirectory.get("Korotkevich");
    }

    private static Map<String, Integer> getArrayWithoutDuplicates(String[] array) {
        Map<String, Integer> arrayWithoutDuplicates = new HashMap<>();

        for (String item : array) {
            if (!arrayWithoutDuplicates.containsKey(item)) {
                arrayWithoutDuplicates.put(item, 1);
            } else {
                arrayWithoutDuplicates.put(item, arrayWithoutDuplicates.get(item) + 1);
            }
        }
        return arrayWithoutDuplicates;
    }
}