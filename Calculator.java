import java.awt.*;
public class Calculator{
    Frame f1;
    public Calculator(){
        f1 = new Frame("My Calculator");
        Panel p = new Panel();
        p.setLayout(new GridLayout(5,3));
        String[] s = {"(", ")", "%", "AC", "7", "8", "9", "÷", "4", "5", "6", "x", "1", "2", "3", "-", "0", ".", "=", "+"};
        for(int i=0;i<s.length;i++)
        p.add(new Button(s[i]));
        f1.add(new TextField(), BorderLayout.NORTH);
        f1.setSize(400,300);
        f1.setVisible(true);
        f1.add(p);
    }
    public static void main(String args[]){
        new Calculator();
    }
}