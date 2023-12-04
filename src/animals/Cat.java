package animals;

public class Cat extends Animal {
    private boolean isSatiety;
    private final int countOfEat;
    public static int countCatInstance;

    public Cat(String name, int age, int countOfEat) {
        super(name, age, 200, 0);
        this.isSatiety = false;
        this.countOfEat = countOfEat;
        countCatInstance++;
    }


    public static int getCountCatInstance() {
        return countCatInstance;
    }

    public int getCountOfEat() {
        return countOfEat;
    }

    public boolean isSatiety() {
        return isSatiety;
    }

    public void printInfo() {
        System.out.println(this.name + " is " + (!this.isSatiety ? "satiety" : "not satiety"));
    }

    public void eating() {
        System.out.println("Cat " + this.name + " ate food");
        isSatiety = true;
    }
}
