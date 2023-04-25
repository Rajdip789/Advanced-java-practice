import java.net.*;
import java.io.*;
import java.util.Scanner;

public class MathClient{
    Socket socket;
    Scanner fromServer;
    PrintWriter toServer;

    MathClient() throws Exception{
        //Create socker objects
        socket = new Socket("localhost", 7778);
        System.out.println("Connection Established.....");

        //Get streams
        fromServer = new Scanner(socket.getInputStream());
        //fromServer.useDelimiter("\n");
        toServer = new PrintWriter(socket.getOutputStream(), true);     
    }

    public static void main(String args[]) throws Exception{
        int choice;
        MathClient mathClient =  new MathClient();
        Scanner scanner = new Scanner(System.in);
        mathClient.fromServer.useDelimiter("\n");
        
        while(true) {
            //Show Menu
            System.out.println(mathClient.fromServer.nextLine());

            // while(mathClient.fromServer.hasNext()) {
            //     System.out.println((mathClient.fromServer.hasNext()));
            //     System.out.println(mathClient.fromServer.next());
            // }
            // System.out.println("Hiiiiiiii");
            
            //Take option from user
            choice = scanner.nextInt();
            //Send option
            mathClient.toServer.println(choice);
            
            if(choice == 5) break;
            //Show message from server after chosing option
            String msg = mathClient.fromServer.nextLine();
            System.out.println(msg);
            if(msg.equals("Wrong option!!")) {
                continue;
            }

            //Take operandes
            mathClient.toServer.println(scanner.nextInt());
            mathClient.toServer.println(scanner.nextInt());

            System.out.println(mathClient.fromServer.nextLine());
        }
        scanner.close();
        mathClient.socket.close();
    }
}
