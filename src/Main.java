public class Main {
    public static void main(String[] args) {
        Box<Apple> box1 = new Box<>();
        box1.addInBox(new Apple());
        box1.addInBox(new Apple());
        box1.addInBox(new Apple());
        System.out.println("Box 1: " + box1.getWeight());

        Box<Apple> box2 = new Box<>();
        box2.addInBox(new Apple());
        box2.addInBox(new Apple());
        box2.addInBox(new Apple());
        box2.addInBox(new Apple());
        System.out.println("Box 2: " + box2.getWeight());

        Box<Orange> box3 = new Box<>();
        box3.addInBox(new Orange());
        box3.addInBox(new Orange());
        box3.addInBox(new Orange());
        System.out.println("Box 3: " + box3.getWeight());

        System.out.println("Compare box 1 and box 3: " + box1.compare(box3));

        box1.addItemsFromBox(box2);
        System.out.println("After insertion: " + box1.getBox());


    }
}