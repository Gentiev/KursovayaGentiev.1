public class Main {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        Main main = new Main();
        employees[0] = new Employee("Andrey Ivanov", 1, 120000.0);
        employees[1] = new Employee("Fedor Ivanov", 2, 112000.0);
        employees[2] = new Employee("Alice Ivanova", 4, 105000.0);
        employees[3] = new Employee("Albert Enstein", 3, 122000.0);
        employees[4] = new Employee("Arkadiy Tsaregradcev", 2, 350000.0);
        employees[5] = new Employee("Irina Generalskaya", 4, 126000.0);
        employees[6] = new Employee("Andrey Kostenko", 1, 392000.0);
        employees[7] = new Employee("Sergey Ekimov", 5, 108000.0);
        employees[8] = new Employee("Samuel Pogosayn", 4, 60000.0);
        employees[9] = new Employee("Andrey Silaev", 5, 120000.0);

        //Для выбора департамента
        int departmentNumber = 2;

        main.indexSalary(10.0);
        main.printEmployeeDetails();
        System.out.println("Сумма всех затрат на зрплаты: \n " + main.findSumAllSalary() + "\n");
        System.out.println("Сотрудник с самой низкой зарплатой: \n " + main.findMinSalary());
        System.out.println("Сотрудник с самой высокой зарплатой: \n " + main.findMaxSalary());
        System.out.println("Средняя зарплата среди сотрудников: \n " + main.findMidlSalary());

        Employee minSalaryEmployee = main.findMinSalaryInDepartment(departmentNumber);
        System.out.println("\nСотрудник с минимальной зарплатой в отделе #" + departmentNumber + ":");
        System.out.println(" " + minSalaryEmployee);

        Employee maxSalaryEmployee = main.findMaxSalaryInDepartment(departmentNumber);
        System.out.println("\nСотрудник с маскимальной зарплатой в отделе #" + departmentNumber + ":");
        System.out.println(" " + maxSalaryEmployee);

        double totalSalaryInDepartment = main.findAllSalaryInDepartment(departmentNumber);
        System.out.println("\nСумма затрат на зарплату в отделе #" + departmentNumber + ":");
        System.out.println(" " + totalSalaryInDepartment);

        double midlSalaryInDepartment = main.findMidlSalaryInDepartment(departmentNumber);
        System.out.println("\nСредняя зарплата в отделе #" + departmentNumber + ":");
        System.out.println(" " + midlSalaryInDepartment);

        main.indexSalaryInDepartment(departmentNumber, 20.0);

        System.out.println("\nСотрудники в отделе #" + departmentNumber + ":");
        main.printEmployeesInDepartment(departmentNumber);

        //Для проверки зп
        double salaryThreshold = 120000.0;
        System.out.println("Сотрудники с зарплатой меньше " + salaryThreshold + ":");
        main.printEmployeesWithSalaryLessThan(salaryThreshold);

        System.out.println("Сотрудники с зарплатой больше или равной " + salaryThreshold + ":");
        main.printEmployeesWithSalaryGreaterThanOrEqual(salaryThreshold);


        main.printAllName();
    }

    public void printEmployeeDetails() {
        for (Employee employee : employees) {
            if (employee != null) System.out.println(employee);
        }
    }

    public double findSumAllSalary() {
        double total = 0.0;
        for (Employee employee : employees) {
            if (employee != null) total += employee.getSalary();
        }
        return total;
    }

    public Employee findMinSalary() {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary())) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public Employee findMaxSalary() {
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary())) {
                    maxSalaryEmployee = employee;
                }
            }
        return maxSalaryEmployee;
    }

    public double findMidlSalary() {
        double total = findSumAllSalary();
        if (employees.length > 0) {
            return total / employees.length;
        }
        return employees.length;
    }

    public void printAllName() {
        System.out.println("\nСписок сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(" " + employee.getName());
            }
        }
    }

    public void indexSalary(double percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                double currentSalary = employee.getSalary();
                double indexedSalary = currentSalary + (currentSalary * percent / 100);
                employee.setSalary(indexedSalary);
            }
        }
    }

    public Employee findMinSalaryInDepartment(int departmentNumber) {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber && (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary())) {
                    minSalaryEmployee = employee;
                }
            }
        return minSalaryEmployee;
    }

    public Employee findMaxSalaryInDepartment(int departmentNumber) {
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber && (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary())) {
                    maxSalaryEmployee = employee;
                }
            }
        return maxSalaryEmployee;
    }

    public double findAllSalaryInDepartment(int departmentNumber) {
        double totalSalary = 0.0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    public double findMidlSalaryInDepartment(int departmentNumber) {
        double totalSalary = 0.0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                totalSalary += employee.getSalary();
                count++;
            }
        }
        if (count > 0) {
            return totalSalary / count;
        } else {
            return 0.0;
        }
    }

    public void indexSalaryInDepartment(int departmentNumber, double percent) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                double currentSalary = employee.getSalary();
                double indexedSalary = currentSalary * (1 + percent/100);
                employee.setSalary(indexedSalary);
            }
        }
    }

    public void printEmployeesInDepartment(int departmentNumber) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                System.out.println(" Employee ID: " + employee.getId());
                System.out.println(" Name: " + employee.getName());
                System.out.println(" Salary: " + employee.getSalary());
                System.out.println();
            }
        }
    }

    public void printEmployeesWithSalaryLessThan(double salaryThreshold) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salaryThreshold) {
                System.out.println(" Employee ID: " + employee.getId());
                System.out.println(" Name: " + employee.getName());
                System.out.println(" Salary: " + employee.getSalary());
                System.out.println();
            }
        }
    }

    public void printEmployeesWithSalaryGreaterThanOrEqual(double salaryThreshold) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salaryThreshold) {
                System.out.println(" Employee ID: " + employee.getId());
                System.out.println(" Name: " + employee.getName());
                System.out.println(" Salary: " + employee.getSalary());
                System.out.println();
            }
        }
    }
}