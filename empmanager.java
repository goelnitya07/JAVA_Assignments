class Employee {
    String name = "Nitya";
    int employeeId = 287;
    double salary = 4000000;

    void displayEmployeeDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {

    void displayManagerDetails() {
        System.out.println("Manager Details:");
        super.displayEmployeeDetails();
    }
}

class empmanager {
    public static void main(String[] args) {

        Manager manager = new Manager();

        manager.displayManagerDetails();
    }
}
