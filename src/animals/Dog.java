package animals;

public class Dog extends Animal {
    public static int countDogInstance;
    public Dog(String name, int age) {
        super(name, age, 500, 10);
        countDogInstance++;
    }
}
