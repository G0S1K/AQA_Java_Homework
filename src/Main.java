import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = generateCollectionInRange(1, 10, 10);
        System.out.println("List 1: " + list1);
        System.out.println("Count of even numbers: " + list1.stream().filter(item -> item % 2 == 0).count());

        List<String> list2 = new ArrayList<>(Arrays.asList("Highload", "High", "Load", "Highload"));
        System.out.println("High: " + list2.stream().filter(item -> Objects.equals(item, "High")).count());
        System.out.println("First elem: " + list2.stream().findFirst().orElse("0"));
        System.out.println("Last elem: " + list2.stream().reduce((first, second) -> second).orElse("0"));

        List<String> list3 = Arrays.asList("f4", "f10", "f2", "f15", "f4");
        System.out.println(Arrays.toString(list3.stream().sorted().toArray(String[]::new)));

        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
        );

        students.stream().
                filter(item -> item.getGender() == Gender.MAN).
                mapToInt(Student::getAge).
                average().ifPresent(item -> System.out.printf("Average of mans: %.2f \n",item));

        System.out.println("A summons will come to:");
        students.stream().filter(item -> item.getGender() == Gender.MAN).
                filter(item -> item.getAge() >= 18 && item.getAge() <= 27).
                map(Student::getName).
                forEach(System.out::println);



        Scanner scanner = new Scanner(System.in);
        List<String> list4 = new ArrayList<>();
        System.out.println("Enter logins: ");
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            list4.add(line);
        }
        System.out.println("Logins with 'f': ");
        list4.stream().filter(item ->item.startsWith("f")).forEach(System.out::println);
    }

    public static List<Integer> generateCollectionInRange(int min, int max, int size) {
        return new Random().ints(size, min, max + 1).boxed().collect(Collectors.toList());
    }

    private enum Gender {
        MAN,
        WOMAN
    }

    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "{" + "name='" + name + '\'' + ", age=" + age + ", gender=" + gender + '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Student)) return false;
            Student student = (Student) obj;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }

}
