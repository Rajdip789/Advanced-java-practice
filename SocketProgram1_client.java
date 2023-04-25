import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
public class SocketProgram1_client{
    SocketProgram1_client() throws Exception{
        Socket s1 = new Socket("localhost", 7778);
        Scanner ip = new Scanner(s1.getInputStream());
        PrintWriter op = new PrintWriter(s1.getOutputStream(), true);
        
        op.println("Hello world");
        System.out.println(ip.nextLine());
        //System.out.println(new Scanner(System.in).nextLine());
        s1.close();
    }
    public static void main(String args[]) throws Exception{
        new SocketProgram1_client();
    }
}
