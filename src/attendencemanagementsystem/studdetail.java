package attendencemanagementsystem;

import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class studdetail extends JFrame implements ActionListener{

    JLabel a,b,c,d,e,f,g,h;
    JTextField name,contact,gr;

    JTextField year,branch,addhar,username;
    JDateChooser dob;
    JPasswordField password;
   // JDateChooser dob;
    JButton submit,cancel;
    Font f1 = new  Font("Tahoma",Font.BOLD,18);

    studdetail(){
        setSize(600,700);

        a = new JLabel("NAME :");
        a.setBounds(60,80,150,50);
        a.setFont(f1);
        add(a);

        b = new JLabel("D.O.B :");
        b.setBounds(60,120,150,50);
        b.setFont(f1);
        add(b);

        d = new JLabel("CONTACT :");
        d.setBounds(60,170,150,50);
        d.setFont(f1);
        add(d);

        c = new JLabel("GR NO :");
        c.setBounds(60,210,150,50);
        c.setFont(f1);
        add(c);

        e = new JLabel("BRANCH");
        e.setBounds(60,280,150,50);
        e.setFont(f1);
        add(e);

        a = new JLabel("YEAR");
        a.setBounds(60,320,150,50);
        a.setFont(f1);
        add(a);

        a = new JLabel("ADDHAR");
        a.setBounds(60,370,150,50);
        a.setFont(f1);
        add(a);

        a = new JLabel("NEW USERNAME");
        a.setBounds(60,420,200,50);
        a.setFont(f1);
        add(a);

        a = new JLabel("NEW PASSWORD");
        a.setBounds(60,470,200,50);
        a.setFont(f1);
        add(a);

        submit = new JButton("SUBMIT");
        submit.setBounds(300,530,150,40);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(100,530,150,40);
        cancel.addActionListener(this);
        add(cancel);

        name = new JTextField();
        name.setBounds(230,90,300,30);
        name.setFont(f1);
        add(name);

        dob = new JDateChooser();
        dob.setBounds(230,127,200,30);
        dob.setFont(f1);
        add(dob);

        contact = new JTextField();
        contact.setBounds(230,177,200,30);
        contact.setFont(f1);
        add(contact);

        gr = new JTextField();
        gr.setBounds(230,217,100,30);
        gr.setFont(f1);
        add(gr);

        branch = new JTextField();
        branch.setBounds(230,287,150,30);
        branch.setFont(f1);
        add(branch);

        year = new JTextField();
        year.setBounds(230,327,150,30);
        year.setFont(f1);
        add(year);

         addhar= new JTextField();
        addhar.setBounds(230,377,200,30);
        addhar.setFont(f1);
        add(addhar);

        username= new JTextField();
        username.setBounds(230,427,170,30);
        username.setFont(f1);
        add(username);

        password= new JPasswordField();
        password.setBounds(230,477,170,30);
        password.setFont(f1);
        add(password);



        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/c2.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 700, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel j1 = new JLabel(i6);
        j1.setBounds(0, 0, 600, 700);
        add(j1);



        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String na = this.name.getText();
            String co = this.contact.getText();
            String g = this.gr.getText();

            String b = this.branch.getText();
            String y = this.year.getText();
            String user = this.username.getText();
            String add = this.addhar.getText();
            String password = String.valueOf(this.password.getPassword());

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
           String dob = dateFormat.format(this.dob.getDate());

           /* String gender = null;
            if (this.male.isSelected()){
                gender = "male";

            } else if (this.female.isSelected()) {
                gender = "female";


            }*/

            conn c = new conn();
            String str = "insert into signup (gr,name,branch,year,dob,addhar,contact,username,password) values('"+g+"','"+na+"','"+b+"','"+y+"','"+dob+"','"+add+"','"+co+"','"+user+"','"+password+"');";
            String s = "insert into studentdata (gr,name,branch) values('"+g+"','"+na+"','"+b+"');";
            String t = "insert into studlogin (username,password) values('"+user+"','"+password+"');";

            try {
                c.s.executeUpdate(str);
                c.s.executeUpdate(s);
                c.s.executeUpdate(t);
                JOptionPane.showMessageDialog(null,"SIGNUP SUCCESSFULL");
                new attendance();





            }catch (Exception e){
                System.out.println(e);
            }

        }
        else if(ae.getSource()==cancel){
            new studlogin();

        }




    }




    public static void main(String[] args){
        new studdetail();
    }



}


