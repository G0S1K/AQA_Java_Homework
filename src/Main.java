import java.io.*;

public class Main {
    public static void main(String[] args) {
        String file = "src/file.csv";
        AppData appData = new AppData(new String[]{"valuer 1", "value 2", "value 3"},
                new int[][]{{1, 2, 3}, {4, 5, 999}});
        saveToFile(file, appData, ";");
        AppData newAppData = loadFromFile(file, ";");
        newAppData.printData();
    }

    public static AppData loadFromFile(String file, String separator) {
        try (BufferedReader out = new BufferedReader(new FileReader(file))) {
            AppData appData = new AppData();
            String firstLine = out.readLine();
            if (firstLine != null) {
                String[] header = firstLine.split(separator);
                int[][] newArray = new int[getCountOfLines(file) - 1][header.length];
                int i = 0;
                String fileLine;
                while ((fileLine = out.readLine()) != null) {
                    String[] values = fileLine.split(";");
                    for (int j = 0; j < values.length; j++) {
                        newArray[i][j] = Integer.parseInt(values[j]);
                    }
                    i++;
                }
                appData.setHeader(header);
                appData.setData(newArray);
            }
            return appData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getCountOfLines(String file) {
        try (BufferedReader out = new BufferedReader(new FileReader(file))) {
            return (int) out.lines().count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveToFile(String file, AppData appData, String separator) {
        try (BufferedWriter in = new BufferedWriter(new FileWriter(file, false))) {
            in.write(String.join(separator, appData.getHeader()) + "\n");
            for (int[] array : appData.getData()) {
                in.write(joinArray(array, ";") + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static StringBuilder joinArray(int[] array, String separator) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            str.append(array[i]);
            if (i < array.length - 1) {
                str.append(separator);
            }
        }
        return str;
    }

}