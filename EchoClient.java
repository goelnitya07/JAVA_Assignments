import java.net.*;
import java.io.*;

public class EchoClient {

    public static void main(String[] args) {

        try {
            Socket s = new Socket("localhost", 6000);

            BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(
                s.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in));

            String msg, reply;

            while (true) {
                System.out.print("Enter message: ");
                msg = keyboard.readLine();

                out.println(msg);

                if (msg.equalsIgnoreCase("exit"))
                    break;

                reply = in.readLine();

                System.out.println("Echo from server: " + reply);
            }

            s.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}