public class Main {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
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

        //Для выбора департамента
        int departmentNumber = 2;

        indexSalary(employees, 10.0);
        printEmployeeDetails(employees);
        System.out.println("Сумма всех затрат на зрплаты: \n " + findSumAllSalary(employees) + "\n");
        System.out.println("Сотрудник с самой низкой зарплатой: \n " + findMinSalary(employees));
        System.out.println("Сотрудник с самой высокой зарплатой: \n " + findMaxSalary(employees));
        System.out.println("Средняя зарплата среди сотрудников: \n " + findMidlSalary(employees));

        Employee minSalaryEmployee = findMinSalaryInDepartment(employees, departmentNumber);
        System.out.println("\nСотрудник с минимальной зарплатой в отделе #" + departmentNumber + ":");
        System.out.println(" " + minSalaryEmployee);

        Employee maxSalaryEmployee = findMaxSalaryInDepartment(employees, departmentNumber);
        System.out.println("\nСотрудник с маскимальной зарплатой в отделе #" + departmentNumber + ":");
        System.out.println(" " + maxSalaryEmployee);

        double totalSalaryInDepartment = findAllSalaryInDepartment(employees, departmentNumber);
        System.out.println("\nСумма затрат на зарплату в отделе #" + departmentNumber + ":");
        System.out.println(" " + totalSalaryInDepartment);

        double midlSalaryInDepartment = findMidlSalaryInDepartment(employees, departmentNumber);
        System.out.println("\nСредняя зарплата в отделе #" + departmentNumber + ":");
        System.out.println(" " + midlSalaryInDepartment);

        indexSalaryInDepartment(employees, departmentNumber, 20.0);

        System.out.println("\nСотрудники в отделе #" + departmentNumber + ":");
        printEmployeesInDepartment(employees, departmentNumber);

        //Для проверки зп
        double salaryThreshold = 120000.0;
        System.out.println("\nСотрудники с зарплатой меньше " + salaryThreshold + ":");
        printEmployeesWithSalaryLessThan(employees, salaryThreshold);

        System.out.println("Сотрудники с зарплатой больше или равной " + salaryThreshold + ":");
        printEmployeesWithSalaryGreaterThanOrEqual(employees, salaryThreshold);


//        printAllName(employees);
    }

    public static void printEmployeeDetails(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }

    public static double findSumAllSalary(Employee[] employees) {
        double total = 0.0;
        for (Employee employee : employees) {
            if (employee != null) {
                total += employee.getSalary();
            }
        }
        return total;
    }

    public static Employee findMinSalary(Employee[] employees) {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;
    }

    public static Employee findMaxSalary(Employee[] employees) {
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }

    public static double findMidlSalary(Employee[] employees) {
        double total = findSumAllSalary(employees);
        return total / employees.length;
    }

    public static void printAllName(Employee[] employees) {
        System.out.println("\nСписок сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(" " + employee.getName());
            }
        }
    }

    public static void indexSalary(Employee[] employees, double percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                double currentSalary = employee.getSalary();
                double indexedSalary = currentSalary + (currentSalary * percent / 100);
                employee.setSalary(indexedSalary);
            }
        }
    }

    public static Employee findMinSalaryInDepartment(Employee[] employees, int departmentNumber) {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                if (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;
    }

    public static Employee findMaxSalaryInDepartment(Employee[] employees, int departmentNumber) {
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                if (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }

    public static double findAllSalaryInDepartment(Employee[] employees, int departmentNumber) {
        double totalSalary = 0.0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    public static double findMidlSalaryInDepartment(Employee[] employees, int departmentNumber) {
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

    public static void indexSalaryInDepartment(Employee[] employees, int departmentNumber, double percent) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                double currentSalary = employee.getSalary();
                double indexedSalary = currentSalary * (1 + percent/100);
                employee.setSalary(indexedSalary);
            }
        }
    }

    public static void printEmployeesInDepartment(Employee[] employees, int departmentNumber) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                System.out.println(" Employee ID: " + employee.getId());
                System.out.println(" Name: " + employee.getName());
                System.out.println(" Salary: " + employee.getSalary());
                System.out.println();
            }
        }
    }

    public static void printEmployeesWithSalaryLessThan(Employee[] employees, double salaryThreshold) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salaryThreshold) {
                System.out.println(" Employee ID: " + employee.getId());
                System.out.println(" Name: " + employee.getName());
                System.out.println(" Salary: " + employee.getSalary());
                System.out.println();
            }
        }
    }

    public static void printEmployeesWithSalaryGreaterThanOrEqual(Employee[] employees, double salaryThreshold) {
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