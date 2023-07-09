package attendencemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class teacherlogin extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField username;
    JPasswordField password;
    JButton signin;
    JButton cancel,signup;
    Font f1 = new  Font("Tahoma",Font.PLAIN,18);
    Font f2 = new  Font("Arial Black",Font.PLAIN,30);
    Font f3 = new  Font("Tahoma",Font.PLAIN,16);
    teacherlogin(){
        //GUI INTERFACE LOGIN FORM
        setSize(600,500);


        //USERNAME TXT
        l1 = new JLabel("Username");
        l1.setBounds(100,120,150,50);
        l1.setFont(f1);
        l1.setForeground(Color.WHITE);
        add(l1);

        //PASSWORD TXT
        l2 = new JLabel("Password");
        l2.setBounds(100,200,150,50);
        l2.setFont(f1);
        l2.setForeground(Color.WHITE);
        add(l2);

        //HEADER LINE
        l3 = new JLabel("TEACHER LOGIN");
        l3.setBounds(170,30,400,50);
        l3.setFont(f2);
        l3.setForeground(Color.WHITE);
        add(l3);

        // USERNAME INPUT
        username = new JTextField();
        username.setBounds(200,130,180,30);
        username.setFont(f3);
        add(username);

        //PASSWORD INPUT
        password = new JPasswordField();
        password.setBounds(200,210,180,30);
        password.setFont(f3);
        add(password);

        //SIGNIN BUTTON
        signin = new JButton("SIGN IN");
        signin.setBounds(180,300,100,40);
        signin.setFont(f3);
        signin.addActionListener(this);
        add(signin);

        signup = new JButton("SIGN UP");
        signup.setBounds(180,370,220,30);
        signup.setFont(f3);
        signup.addActionListener(this);
        add(signup);

        //CANCEL BUTTON
        cancel = new JButton("CANCEL");
        cancel.setBounds(300,300,100,40);
        cancel.setFont(f3);
        cancel.addActionListener(this);
        add(cancel);

        //BACKGROUND IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/i3.jpg"));
        Image i3  = i1.getImage().getScaledInstance(600,500,Image.SCALE_SMOOTH);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel i2 = new JLabel(i4);
        i2.setBounds(0,0,600,500);
        add(i2);

        setLayout(null);
        setLocationRelativeTo(null);          //GUI INTERFACE LOGIN FORM
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        //ACTION ASSIGNING TO SIGNIN BUTTON
        if(ae.getSource()==signin){
            String username = this.username.getText();
            String password = String.valueOf(this.password.getPassword());
            conn c = new conn();
            try {
                String str1 = "select * from login where username = '"+username+"' and password = '"+password+"';";
                ResultSet rs = c.s.executeQuery(str1);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Login successfull!");
                     new attendance();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid password or username");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        //ACTION ASSIGNING TO CANCEL BUTTON
        if(ae.getSource()==cancel){
            System.exit(0);
        } else if (ae.getSource()==signup) {
            new studdetail();
        }

    }

    public static void main(String[] args){
        new teacherlogin();
    }
}

