import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> box;

    public Box() {
        this.box = new ArrayList<>();
    }

    public ArrayList<T> getBox() {
        return box;
    }

    public void addInBox(T item) {
        box.add(item);
    }

    public float getWeight() {
        return (float) box.stream()
                .mapToDouble(Fruit::getWeight)
                .sum();
    }

    public boolean compare(Box<?> compareBox) {
        return getWeight() == compareBox.getWeight();
    }

    public void addItemsFromBox(Box<T> addBox) {
        box.addAll(addBox.getBox());
        addBox.getBox().clear();
    }
}
