import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

class PatientFile {

    public static void main(String[] args) {

        try {
            FileWriter writer = new FileWriter("patient.txt");

            writer.write("Patient ID: 287\n");
            writer.write("Name: Nitya\n");
            writer.write("Age: 18\n");
            writer.write("Diagnosis: Fever\n");
            writer.close();

            System.out.println("Patient details written to file.");
        }
        catch (IOException writeError) {
            System.out.println("Error while writing to file.");
        }
        try {
            FileReader reader = new FileReader("patient.txt");
            BufferedReader br = new BufferedReader(reader);

            String line;
            System.out.println("\nPatient Details:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        }
        catch (IOException readError) {
            System.out.println("Error while reading file.");
        }
    }
}