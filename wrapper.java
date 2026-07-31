public class wrapper {
    public static void main(String[] args){

        //taking student marks as strings

        String mark1 = "89";
        String mark2 = "72";
        String mark3 = "94";
        String mark4 = "77";
        String mark5 = "99";

        //converting strings to integers

        int m1 = Integer.parseInt(mark1);
        int m2 = Integer.parseInt(mark2);
        int m3 = Integer.parseInt(mark3);
        int m4 = Integer.parseInt(mark4);
        int m5 = Integer.parseInt(mark5);

        int total = m1 + m2 + m3 + m4 + m5;

        System.out.println("Marks of student A: " + m1);
        System.out.println("Marks of student B: " + m2);
        System.out.println("Marks of student C: " + m3);
        System.out.println("Marks of student D: " + m4);
        System.out.println("Marks of student E: " + m5);
        System.out.println("Total Marks:  " + total);

        //float f=Float.parseFloat(s);
        //double d=Double.parseDouble(s);
        //System.out.println(f);
    }
    
}
