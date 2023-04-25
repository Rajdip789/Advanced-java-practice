import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class JavaMessenger_server extends WindowAdapter implements ActionListener{
    Frame f1;
    TextField t;
    Panel p11;
    Button send;
    Label l[] = new Label[10];

    ServerSocket sk1;
    Socket s1;
    BufferedReader ip;
    PrintWriter op;

    boolean flag;
    public JavaMessenger_server(){
        System.out.println("Server Object Created"); 
    }

    public void prepareGUI(){
        f1 = new Frame("Java Messenger Server");
        Panel p1 = new Panel();
        p1.setLayout(new BorderLayout());

        p11 = new Panel();
        p11.setLayout(new GridLayout(10,1));
        for(int i=0;i<10;i++){
            l[i]=new Label();
            p11.add(l[i]);
        }
        Panel p12 = new Panel();
        p12.setLayout(new BorderLayout());

        t = new TextField();
        p12.add(t,BorderLayout.CENTER);
        send = new Button("Send");
        p12.add(send,BorderLayout.EAST);

        p1.add(p11,BorderLayout.CENTER);
        p1.add(p12,BorderLayout.SOUTH);
  
        f1.add(p1,BorderLayout.CENTER);
        f1.setSize(500,300);
        f1.setBackground(new Color(102,255,102));
        f1.setVisible(true);

        

        f1.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                try{
                    if(!s1.isClosed()){
                        op.println("-1");
                        flag = false;  
                    }
                    ((Frame)e.getSource()).dispose(); 
                }catch(Exception e1){
                    System.out.println(e1);
                }
            }
        });

        send.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if((!t.getText().trim().equals("")) && (!s1.isClosed())){            
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
            flag=true;
            System.out.println("Connection Established");

            ip = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            op = new PrintWriter(s1.getOutputStream(), true);

            while(true){
                String msg=ip.readLine();
                if((flag == false) || (msg.equals("-1"))){
                    break;
                }
                for(int i=1;i<10;i++){
                    l[i-1].setText(l[i].getText());
                    l[i-1].setAlignment(l[i].getAlignment());
                }
                l[9].setText(msg);
                l[9].setAlignment(Label.LEFT);               
            }
            s1.close();
            System.out.println("Connection is closed");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        JavaMessenger_server obServer = new JavaMessenger_server();
        obServer.prepareGUI();
        obServer.prepareConnection();
    }
}

