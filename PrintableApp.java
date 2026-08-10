interface Printable {
    void printDetails();
}

class Student implements Printable {

    String name = "Nitya";
    int rollNo = 287;

    public void printDetails() {
        System.out.println("Student Details");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNo);
    }
}

class Employee implements Printable {

    String name = "Navya";
    int employeeId = 921;

    public void printDetails() {
        System.out.println("Employee Details");
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
    }
}

class PrintableApp {

    public static void main(String[] args) {

        Student student = new Student();
        Employee employee = new Employee();
        student.printDetails();
        System.out.println();
        employee.printDetails();
    }
}