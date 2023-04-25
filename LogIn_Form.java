import java.awt.*;
import java.awt.event.*;
public class LogIn_Form implements ActionListener,WindowListener{
    Frame f;
    TextField user, pass;
    Button submit, cancel;
    public LogIn_Form(){
        f = new Frame("LogIn Form of My Project: ");
        Panel p = new Panel();
        f.setVisible(true);
        f.setLayout(new FlowLayout());
        f.setSize(400,240);
        p.setLayout(new GridLayout(3,2));
        p.add(new Label("Login"));
        user = new TextField();
        p.add(user);
        p.add(new Label("Password"));
        pass = new TextField();
        pass.setEchoChar('*');
        p.add(pass);
        submit = new Button("OK");
        cancel = new Button("Cancel");
        p.add(submit);
        p.add(cancel);
        f.add(p);
        
        f.addWindowListener(this);
        submit.addActionListener(this);
        cancel.addActionListener(this);
    }

    public void windowActivated(WindowEvent e) {}  
    public void windowClosed(WindowEvent e) {} 
    public void windowDeactivated(WindowEvent e) {}  
    public void windowDeiconified(WindowEvent e) {}  
    public void windowIconified(WindowEvent e) {}  
    public void windowOpened(WindowEvent e) {}
    public void windowClosing(WindowEvent e){
        ((Frame)e.getSource()).dispose();
    }

    public void actionPerformed(ActionEvent e){
        if(((Button)e.getSource()).equals(submit)){
            Frame f2 = new Frame("Message Alert");
            f2.setLayout(new GridLayout(2,1));
            f2.setSize(150,100);
            f2.setVisible(true);
            f2.add(new Label("User Name: "+user.getText()));
            f2.add(new Label("Password: "+pass.getText()));
            f2.addWindowListener(this);
        }
        else{
            user.setText("");
            pass.setText("");
        }
    }
    public static void main(String args[]){
        new LogIn_Form();
    }
}

// import java.awt.*;
// public class LogIn_Form{
//    public static void main(String[] args) {
//        Frame f = new Frame();
//        f.setSize(400,300);
//        f.setLayout(null);
//        f.setVisible(true);
//        Label l1 = new Label("Enter user ID: ");
//        l1.setBounds(80,100,100,20);
//        Label l2 = new Label("Enter password: ");
//        l2.setBounds(80,130,100,20);
//        TextField t1 = new TextField(10);
//        t1.setBounds(200,100,100,20);
//        TextField t2 = new TextField(10);
//        t2.setEchoChar('*');
//        t2.setBounds(200,130,100,20);
//        Button b1 = new Button("LogIn");
//        Button b2 = new Button("Cancel");
//        b1.setBounds(120,160,50,20);
//        b2.setBounds(180,160,50,20);
//        f.add(l1);
//        f.add(t1);
//        f.add(l2);
//        f.add(t2);
//        f.add(b1);
//        f.add(b2);
//    }
// }