import java.util.Scanner;

public class payroll {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        String empIDStr = sc.nextLine();

        System.out.print("Enter basic salary: ");
        String salaryStr = sc.nextLine();

        System.out.print("Enter bonus amount: ");
        String bonusStr = sc.nextLine();

        Integer empID = Integer.valueOf(empIDStr);
        Integer salary = Integer.valueOf(salaryStr);
        Integer bonus = Integer.valueOf(bonusStr);

        if (salary <= 0 || bonus <= 0){
            System.out.println("Invalid Entries!");
        }

        else{
            double netSalary = salary + bonus;

            System.out.println("Employee ID: "+ empID);
            System.out.println("Employee Salary: "+ salary);
            System.out.println("Bonus given to Employee: "+ bonus);
            System.out.println("Net Salary: "+ netSalary);
        }
        sc.close();
    }
}
