public class Park {
    private final String name;
    private final Attraction[] attractions;

    Park(String name, int arraySize) {
        this.name = name;
        this.attractions = new Attraction[arraySize];
    }

    public void addAttraction(int index, String name, String workingTime, int cost) {
        if (index < attractions.length && index >= 0 && attractions[index] == null) {
            attractions[index] = new Attraction(name, workingTime, cost);
        } else System.out.println("Element already exists");
    }

    public void printParkInfo() {
        System.out.println("Park name: " + this.name);
        for (Attraction attraction: attractions) {
            if (attraction != null) {
                System.out.println("Name: " + attraction.name +
                        "\nWorking time: " + attraction.workingTime +
                        "\nCost: " + attraction.cost + "$");
            }
        }
    }

    public static class Attraction {
        public String name;
        public String workingTime;
        public int cost;

        Attraction(String name, String workingTime, int cost) {
            this.name = name;
            this.workingTime = workingTime;
            this.cost = cost;
        }
    }
}
