import java.net.*;
import java.io.*;
import java.util.Scanner;

public class SocketProgram1_client{
    SocketProgram1_client() throws Exception{
        Socket s1 = new Socket("localhost", 7778);

        System.out.println("Connection Established");

        Scanner ip = new Scanner(s1.getInputStream());
        PrintWriter op = new PrintWriter(s1.getOutputStream(), true);
        
        System.out.println(ip.nextLine());
        op.println("Hello world from client.......");
        
        s1.close();
    }
    public static void main(String args[]) throws Exception{
        new SocketProgram1_client();
    }
}
