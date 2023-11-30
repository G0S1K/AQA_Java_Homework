import java.util.ArrayList;
import java.util.List;

public class TelephoneDirectory {
    private final List<Person> directory;

    public TelephoneDirectory() {
        directory = new ArrayList<>();
    }

    public void add(String secondName, String phoneNumber) {
        directory.add(new Person(secondName, phoneNumber));
    }

    public void get(String secondName) {
        System.out.println("Second name: " + secondName);
        System.out.println("Phones: ");
        for (Person person : directory) {
            if (person.getSecondName().equalsIgnoreCase(secondName)) System.out.println(person.getPhoneNumber());
        }
    }
}
