import java.net.*;
import java.io.*;
import java.util.Scanner;

public class MathServer {
    ServerSocket serverSocket;
    Scanner fromClient;
    PrintWriter toClient;

    MathServer() throws Exception {
        // Create socket objects
        serverSocket = new ServerSocket(7778);

        Socket socket = serverSocket.accept();
        System.out.println("Connection Established.....");

        // Get streams
        fromClient = new Scanner(socket.getInputStream());
        toClient = new PrintWriter(socket.getOutputStream(), true);
    }

    public static void main(String args[]) throws Exception {
        int choice; 
        double x, y, res = 0.0;
        MathServer mathServer = new MathServer();

        while(true) {
            mathServer.toClient.println("-------Menu-------1. Add2. Subtract3. Multiply4. DivisionChoose a option: ");
            choice = Integer.parseInt(mathServer.fromClient.nextLine());

            if(choice <= 4 && choice >= 1) {

                mathServer.toClient.println("Enter the operands: ");
                x = Integer.parseInt(mathServer.fromClient.nextLine());
                y = Integer.parseInt(mathServer.fromClient.nextLine());

                switch(choice) {
                    case 1: res = x+y;
                        break;
                    case 2: res = x-y;
                        break;
                    case 3: res = x*y;
                        break;
                    case 4: res = x/y;
                        break;
                }
                mathServer.toClient.println("Result: " + res);    
            }else if(choice == 5) {
                break;
            } else {
                mathServer.toClient.println("Wrong option!!");
            }
        }

        mathServer.serverSocket.close();
    }
}
