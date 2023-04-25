import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
public class SocketProgram1_server{
    SocketProgram1_server() throws Exception{
        ServerSocket sk1 = new ServerSocket(7778);
        Socket s1 = sk1.accept();

        System.out.println("Connection Established");
        Scanner ip = new Scanner(s1.getInputStream());
        PrintWriter op = new PrintWriter(s1.getOutputStream(), true);

        System.out.println(ip.nextLine());
        op.println("Bye world");
        System.out.println(new Scanner(System.in).nextLine());
        s1.close();
        System.out.println(s1.isClosed());
    }
    public static void main(String args[]) throws Exception{
        new SocketProgram1_server();
    } 
}
