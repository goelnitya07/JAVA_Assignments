public class default_parameter {
    String name;
    int roll;
    default_parameter(){
        name = "";
        roll = 0;
    }
    default_parameter(int r, String n){
        name = n;
        roll = r;
    }
    void display(){
        System.out.println("Roll No.: "+ roll);
        System.out.println("Name: "+ name);
    }

    static void main (String[] args){
        new default_parameter().display();
        new default_parameter(287,"Nitya Goel").display();
    }
}
