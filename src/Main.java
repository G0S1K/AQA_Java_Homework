public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Gleb Korotkevich", 21, "AQA engineer", "glebb.korotkevich@gmail.com", "+375449997788", 5000);
        employees[1] = new Employee("Kirill Abdul", 46, "Unity developer", "abdul@gmail.com", "+375449945678", 3000);
        employees[2] = new Employee("Denis Pomaz", 30, "Frontend developer", "pomaz@gmail.com", "+375441237788", 2000);
        employees[3] = new Employee("Victor Rachk", 50, "Annalist", "rachk@gmail.com", "+375449997567", 6000);
        employees[4] = new Employee("Egor Fesk", 21, "Backend engineer", "fesk@gmail.com", "+375442967888", 5500);

        for (Employee employee : employees) {
            if (employee.age > 40) employee.printEmployee();
        }

        System.out.println("-------------");

        Park park = new Park("Park1", 3);
        park.addAttraction(0, "Koleso", "09:00-21.00", 5);
        park.addAttraction(1, "Kolobok", "10:00-21.00", 6);
        park.addAttraction(2, "Tarelka", "09:00-22.00", 10);
        park.printParkInfo();
    }
}