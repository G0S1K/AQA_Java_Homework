public class Employee {
    public String name;
    public int age;
    public String position;
    public String email;
    public String phone;
    public int salary;

    Employee(String name, int age, String position, String email, String phone, int salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
    }

    public void printEmployee() {
        System.out.println("Name: " + this.name +
                "\nAge: " + this.age +
                "\nPosition: " + this.position +
                "\nEmail: " + this.email +
                "\nPhone: " + this.phone +
                "\nSalary: " + this.salary + "$");
    }
}
