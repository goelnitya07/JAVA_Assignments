import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc_con {
    
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String db = "jdbc:mysql://root:3306/Assignment2.sql";
        String user = "root";
        String password = "root";

        try{
            Connection con = DriverManager.getConnection(db,user,password);
            System.out.println("Connection Established!");
            con.close();
        }
        catch (Exception e){
            System.out.println("Connection not established");
        }
    }
}
