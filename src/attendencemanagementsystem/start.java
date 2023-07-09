package attendencemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class start extends JFrame implements ActionListener {

    JButton student,teacher;

    Font f3 = new  Font("Tahoma",Font.BOLD,28);

    start(){
        setSize(700,500);

        student = new JButton("STUDENT");
        student.setBounds(230,150,200,50);
        student.setFont(f3);
        student.addActionListener(this);
        add(student);

        teacher = new JButton("TEACHER");
        teacher.setBounds(230,250,200,50);
        teacher.setFont(f3);
        teacher.addActionListener(this);
        add(teacher);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/c3.jpg"));
        Image i5 = i4.getImage().getScaledInstance(700,500, Image.SCALE_SMOOTH);
        ImageIcon i6= new ImageIcon(i5);
        JLabel j1 = new JLabel(i6);
        j1.setBounds(1,1,700,500);
        add(j1);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==student){
            new studlogin();
        }
        else if(ae.getSource()==teacher) {
            new teacherlogin();

        }
    }

    public static void main(String[] args) {
        new start();
    }
}
