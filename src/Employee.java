import java.util.Objects;
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

    public void setName(String name) {
        this.name = name;
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
    public int hashCode() {
        Objects objects;
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee " + "id" + id + ", name: " + name + ", department: " + department + ", salary: " + salary + "\n";
    }

    //Summa vseh ZP
    public static double findSumAllSalary(Employee[] employees) {
        double total = 0.0;
        for (Employee employee : employees) {
            total += employee.salary;
        }
        return total;
    }

    //Min ZP
    public static Employee findMinSalary(Employee[] employees) {
        Employee minSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.salary < minSalary.salary) {
                minSalary = employee;
            }
        }
        return minSalary;
    }

    //Max ZP
    public static Employee findMaxSalary(Employee[] employees) {
        Employee maxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.salary > maxSalary.salary) {
                maxSalary = employee;
            }
        }
        return maxSalary;
    }

    //Midl line of ZP
    public static double findMidlSalary(Employee[] employees) {
        double total = findSumAllSalary(employees);
        return (double) total / employees.length;
    }

    //name all employees
    public static void printAllName(Employee[] employees) {
        System.out.println("\nСписок сотрудников:");
        for (Employee employee : employees) {
            System.out.println("   " + employee.name);
        }
    }
}