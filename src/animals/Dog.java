package animals;

public class Dog extends Animal {
    private static int countDogInstance;
    public Dog(String name, int age) {
        super(name, age, 500, 10);
        countDogInstance++;
    }

    public static int getCountDogInstance() {
        return countDogInstance;
    }
}
