import animals.*;
import geometry.*;
public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Bobik", 10, 0, 0);
        animal.run(100);

        Plate plate = new Plate(30);
        System.out.println("Count of food on the plate: " + plate.getCountOfFood());

        Dog dog = new Dog("Lenich", 10);
        dog.swim(30);

        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Barsik", 10, 11);
        cats[1] = new Cat("Lisa", 8, 5);
        cats[2] = new Cat("Klavik", 14, 30);
        cats[3] = new Cat("Barbos", 4, 6);

        System.out.println("Count cats: " + Cat.getCountCatInstance());
        System.out.println("Count dogs: " + Dog.getCountDogInstance());
        System.out.println("Count animals: " + Animal.getCountAnimalInstance());

        cats[0].run(50);

        for (Cat cat : cats) {
            if (plate.eatingFromPlate(cat.getCountOfEat())) cat.eating();
            else System.out.println(cat.getName() + " cant eat form this plate. He needs " + cat.getCountOfEat());
        }

        System.out.println("Count of food on the plate: " + plate.getCountOfFood());

        System.out.println("--------------------------");

        Circle circle = new Circle(4.0, "Green", "Red");
        circle.printInfo();

        Rectangle rectangle = new Rectangle(5.0, 6.0, "Red", "Green");
        rectangle.printInfo();

        Triangle triangle = new Triangle(7.0, 7.0,10.0, "Black", "Gray");
        triangle.printInfo();
    }
}