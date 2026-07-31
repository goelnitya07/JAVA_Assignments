import java.util.ArrayList;

public class todolist {
    public static void main(String[] args){
        ArrayList<String> arrl = new ArrayList<>();
        arrl.add("Clean up my room");
        arrl.add("Study JAVA");
        arrl.add("Induction roundup");
        arrl.add("Prepare a speech");
        
        StringBuffer sb = new StringBuffer();
        sb.append("TO DO LIST:");
        sb.append(arrl);
        System.out.println(sb);
    }
}
