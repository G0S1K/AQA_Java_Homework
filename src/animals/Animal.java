package animals;

public class Animal {
    protected final String name;
    protected final int age;
    protected int runLimit;
    protected int swimLimit;

    public static int countAnimalInstance;

    public Animal(String name, int age, int runLimit, int swimLimit) {
        this.name = name;
        this.age = age;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        countAnimalInstance++;
    }

    public void run(int distance) {
        if (distance < this.runLimit) System.out.printf("%s ran %d meters\n", this.name, distance);
        else System.out.println("This animal can't run that many meters");
    }

    public void swim(int distance) {
        if (distance < this.runLimit) System.out.printf("%s swam %d meters\n", this.name, distance);
        else System.out.println("This animal can't swim that many meters");
    }
}
