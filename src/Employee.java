public class Employee {
    private static int idCounter = 1;
    private int id;
    private String name;
    private int department;
    private double salary;

    public Employee(String name, int department, double salary) {
        this.id = idCounter++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public String toString() {
        return "Employee " + "id" + id + ", name: " + name + ", department: " + department + ", salary: " + salary + "\n";
    }
}