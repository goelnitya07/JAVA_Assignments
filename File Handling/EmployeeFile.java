import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

class EmployeeFile {

    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("employee.txt");
            writer.write("Employee ID: 287\n");
            writer.write("Name: Nitya\n");
            writer.write("Department: Computer Science\n");
            writer.write("Salary: 5000000\n");
            writer.close();

            System.out.println("Employee details written to file.");
        }
        catch (IOException e) {
            System.out.println("Error while writing to file.");
        }

        try {
            FileReader reader = new FileReader("employee.txt");
            BufferedReader br = new BufferedReader(reader);
            String line;

            System.out.println("\nEmployee Details:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
            br.close();
        }
        catch (IOException e) {
            System.out.println("Error while reading file.");
        }
    }
}