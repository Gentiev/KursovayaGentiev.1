public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Andrey Ivanov", 1, 120000.0);
        employees[1] = new Employee("Fedor Ivanov", 2, 112000.0);
        employees[2] = new Employee("Alice Ivanova", 4, 105000.0);
        employees[3] = new Employee("Albert Enstein", 3, 122000.0);
        employees[4] = new Employee("Arcadiy Tsaregradcev", 2, 350000.0);
        employees[5] = new Employee("Irina Generalskaya", 4, 126000.0);
        employees[6] = new Employee("Andrey Kostenko", 1, 392000.0);
        employees[7] = new Employee("Sergey Ekimov", 5, 108000.0);
        employees[8] = new Employee("Samuel Pogosayn", 4, 60000.0);
        employees[9] = new Employee("Andrey Silaev", 5, 120000.0);

        for (Employee employee : employees)
            if (employee != null) {
                System.out.println(employee.toString());
            }
        System.out.println("Сумма всех затрат на зрплаты: \n" + Employee.findSumAllSalary(employees) + "\n");
        System.out.println("Сотрудник с самой низкой зарплатой: \n" + Employee.findMinSalary(employees));
        System.out.println("Сотрудник с самой высокой зарплатой: \n" + Employee.findMaxSalary(employees));
        System.out.println("Средняя зарплата среди сотрудников: \n" + Employee.findMidlSalary(employees));
        Employee.printAllName(employees);
    }
}