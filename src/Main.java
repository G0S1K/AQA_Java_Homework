import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrayForTask6 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] arrayForTask7 = new int[100];
        int[] arrayForTask8 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] arrayForTask9 = {{2, 5, 6}, {6, 7, 9}, {3, 8, 4}};
        System.out.println(Arrays.toString(changeArray(arrayForTask6)));
        System.out.println(Arrays.toString(initArray(arrayForTask7)));
        System.out.println(Arrays.toString(multiplyValue(arrayForTask8)));
        printMatrix(changeDiagonalValues(arrayForTask9));
        System.out.println(Arrays.toString(getInitArray(5, 8)));
    }

    //task_1
    public static boolean isSumInRange(int firstValue, int secondValue) {
        int sum = firstValue + secondValue;
        return sum >= 10 && sum <= 20;
    }

    //task_2
    public static void printStrInLoop(String str, int iterationCount) {
        for (int i = 1; i <= iterationCount; i++) {
            System.out.println(str);
        }
    }

    //task_3
    public static void printValueStatus(int value) {
        if (value >= 0) {
            System.out.print("It's a positive value");
        } else {
            System.out.print("It's a negative value");
        }
    }

    //task_4
    public static boolean isNotPositive(int value) {
        return value < 0;
    }

    //task_5
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
    }

    //task_6
    public static int[] changeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) array[i] = 1;
            else array[i] = 0;
        }
        return array;
    }

    //task_7
    public static int[] initArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    //task_8
    public static int[] multiplyValue(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
        return array;
    }

    //task_9
    public static int[][] changeDiagonalValues(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || j == array.length - i - 1) array[i][j] = 1;
            }
        }
        return array;
    }

    public static void printMatrix(int[][] array) {
        for (int[] ints : array) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();
        }
    }

    //task_10
    public static int[] getInitArray(int length, int initialValue) {
        int [] newArray = new int[length];
        Arrays.fill(newArray, initialValue);
        return newArray;
    }
}