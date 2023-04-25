import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
public class JavaMessenger_MultiClient_Server extends WindowAdapter implements ActionListener, Runnable{
    Frame f1;
    TextField t;
    Panel p21;
    Button send;
    Label l[] = new Label[10];

    ServerSocket sk1;
    Socket s1;
    Scanner ip;
    PrintWriter op;

    Thread ipthread;
    boolean bl1=true;

    public JavaMessenger_MultiClient_Server(){
        System.out.println("Server Object Created"); 
    }

    public void prepareGUI(){
        f1 = new Frame("Java Messenger Server");
        Panel p1 = new Panel(), p2 = new Panel();
        p1.setLayout(new GridLayout(5,1));
        p1.setSize(200,500);
        p1.add(new Button("         TestClient          "));
        p2.setLayout(new BorderLayout());

        p21 = new Panel();
        p21.setLayout(new GridLayout(10,1));
        for(int i=0;i<10;i++){
            l[i]=new Label();
            p21.add(l[i]);
        }
        Panel p22 = new Panel();
        p22.setLayout(new BorderLayout());

        t = new TextField();
        p22.add(t,BorderLayout.CENTER);
        send = new Button("Send");
        p22.add(send,BorderLayout.EAST);

        p2.add(p21,BorderLayout.CENTER);
        p2.add(p22,BorderLayout.SOUTH);

        f1.add(p1,BorderLayout.WEST);   
        f1.add(p2,BorderLayout.CENTER);
        f1.setSize(500,300);
        f1.setBackground(new Color(102,255,102));
        f1.setVisible(true);

        

        f1.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                bl1=false;
                ((Frame)e.getSource()).dispose();
            }
        });

        send.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(t.getText().length() != 0){
            String msg = t.getText();
            for(int i=1;i<10;i++){
                l[i-1].setText(l[i].getText());
                l[i-1].setAlignment(l[i].getAlignment());
            }
            l[9].setText(msg);
            l[9].setAlignment(Label.RIGHT);
            t.setText("");
            op.println(msg);
        }
    }

    public void prepareConnection(){
        try{
            
            sk1 = new ServerSocket(7777);
            s1 = sk1.accept();
            System.out.println("Connection Established");

            ip = new Scanner(s1.getInputStream());
            op = new PrintWriter(s1.getOutputStream(), true);

            ipthread = new Thread(this);
            ipthread.start();
        }catch(Exception e){
            System.out.print(e);
        }
    }

    public void run(){
        while(bl1){
            String msg =ip.nextLine();
            if(msg != ""){
                for(int i=1;i<10;i++){
                    l[i-1].setText(l[i].getText());
                    l[i-1].setAlignment(l[i].getAlignment());
                }
                l[9].setText(msg);
                l[9].setAlignment(Label.LEFT);
            } 
        }
    }
    
    public static void main(String[] args){
        JavaMessenger_MultiClient_Server obServer = new JavaMessenger_MultiClient_Server();
        obServer.prepareGUI();
        obServer.prepareConnection();
    }
}

