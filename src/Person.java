public class Person {
    private final String secondName;
    private final String phoneNumber;
    public Person(String secondName, String phoneNumber) {
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSecondName() {
        return secondName;
    }
}
