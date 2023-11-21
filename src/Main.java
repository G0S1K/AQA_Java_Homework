import animals.*;
public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Bobik", 10, 0, 0);
        animal.run(100);
        System.out.println();

        Plate plate = new Plate(30);

        Dog dog = new Dog("Lenich", 10);

        dog.swim(30);

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Barsik", 10, 11);
        cats[1] = new Cat("Lisa", 8, 5);
        cats[2] = new Cat("Barbos", 4, 6);

        cats[0].run(50);

        for (Cat cat : cats) {
            if (plate.eatingFromPlate(cat.getCountOfEat())) cat.eating();
        }

        System.out.println("Count of food on the plate: " + plate.getCountOfFood());

    }
}