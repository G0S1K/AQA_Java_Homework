public class AppData {
    private String[] header;
    private int[][] data;

    public AppData() {}
    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public void printData() {
        if (header != null) {
            System.out.print("Header: ");
            for (String headerItem : header) {
                System.out.print(headerItem + " ");
            }

            System.out.println();

            System.out.println("Data:");
            for (int[] row : data) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
    }
}
