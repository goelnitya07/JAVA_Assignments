import java.util.ArrayList;
import java.util.Scanner;

public class studentcourseregis {
    public static void main(String[] args){
        ArrayList<String> arrl = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String choice;
        do{
            System.out.println("1. Add, 2. Remove, 3. Display, 4. Exit");
            choice = sc.nextLine().trim();
            if (choice.equals("1")){
                System.out.println("Enter the course name to add: ");
                arrl.add(sc.nextLine().trim());
            }

            else if (choice.equals("2")){
                System.out.println("Enter the course name to remove:");
                arrl.remove(sc.nextLine().trim());
            }
            else if (choice.equals("3")){
                System.out.println("The list of courses is: "+arrl);
            }
            }
        while(!choice.equals("4"));
        sc.close();
        }
}
