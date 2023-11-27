public class Main {
    public static void main(String[] args) {
        String[][] array = new String[][]{
                {"1", "3", "4", "5"},
                {"0", "6", "0o", "8"},
                {"3", "6", "7", "8"},
                {"3", "5", "8", "9"}
        };
        try {
            System.out.println(getSum(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array.length != 4 || array[i].length != 4 ) throw new MyArraySizeException("Array size isn't 4x4");
            for (int j = 0; j < array[i].length; j++) {
                try{
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Parsing exception at [" + i + ", " + j + "]");
                }
            }
        }
        return sum;
    }
}
