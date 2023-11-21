package animals;

public class Plate {
    private int countOfFood;

    public Plate(int countOfEat) {
        this.countOfFood = countOfEat;
    }

    public int getCountOfFood() {
        return countOfFood;
    }

    public void addEatToPlate(int count) {
        if (count > 0) countOfFood += count;
    }

    public boolean eatingFromPlate(int count) {
        if (count < countOfFood) {
            countOfFood -= count;
            return true;
        } else {
            return false;
        }
    }
}
