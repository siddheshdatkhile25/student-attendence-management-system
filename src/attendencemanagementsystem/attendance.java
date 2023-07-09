package attendencemanagementsystem;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public  class attendance extends JFrame implements ActionListener {
    JLabel l1;
    JTable t1, def;
    JButton ADD, UPDATE, calculate, back;
    JButton home;
    JLabel d1, d2, d3, d4;
    int y = 75;
    int lw = 80;
    int lh = 20;

    public attendance() {
        setSize(800, 500);


        t1 = new JTable();
        t1.setBounds(450, 100, 250, 300);
        add(t1);

        def = new JTable();
        def.setBounds(450, 150, 250, 100);

        l1 = new JLabel("Select the operation");
        l1.setFont(new Font("SERIF", Font.BOLD, 32));
        l1.setForeground(Color.DARK_GRAY);
        l1.setBounds(220, -10, 400, 100);
        add(l1);


        ADD = new JButton();
        ADD.setText("ADD");
        ADD.setFont(new Font("SERIF", Font.BOLD, 15));
        ADD.setForeground(Color.BLACK);
        ADD.setBounds(60, 100, 150, 50);
       ADD.addActionListener(this);
        add(ADD);

        UPDATE = new JButton("UPDATE");
        UPDATE.setForeground(Color.BLACK);
        UPDATE.setFont(new Font("SERIF",Font.BOLD,13));
        UPDATE.setBounds(60,200,150,50);
        UPDATE.addActionListener(this);
        add(UPDATE);

        calculate = new JButton("Defaulters");
        calculate.setForeground(Color.BLACK);
        calculate.setFont(new Font("SERIF", Font.BOLD, 15));
        calculate.setBounds(60, 300, 150, 50);
       calculate.addActionListener(this);
        add(calculate);

        d1 = new JLabel("Name");
        d1.setBounds(550, 70, 150, 30);
        add(d1);

        d2 = new JLabel("Roll.No");
        d2.setBounds(460, 70, 150, 30);
        add(d2);

        d3 = new JLabel("Attendance");
        d3.setBounds(625, 70, 150, 30);
        add(d3);

        d4 = new JLabel("Defaulters");
        d4.setBounds(550, 70, 150, 30);



        //dasboard button
        /*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/back-arrow.png"));
        Image i2 = i1.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        home = new JButton(i3);
        home.setBounds(940, 5, 35, 30);*/
        //home.addActionListener(this);
        //add(home);

        //back button
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("images/back-arrow.png"));
        Image i12 = i11.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon i13 = new ImageIcon(i12);
        back = new JButton(i13);
        back.setBounds(5, 5, 35, 35);

        back.addActionListener(this);
        add(back);

        //home.setLayout(null);
       // home.setVisible(true);

        try {
            conn c = new conn();
            String str = "select gr,name, attendance from studentdata ORDER BY gr ASC";
            ResultSet rs = c.s.executeQuery(str);
              t1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }



        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/c4.jpg"));
        Image i5 = i4.getImage().getScaledInstance(800, 450, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel j1 = new JLabel(i6);
        j1.setBounds(0, 0, 800, 450);
        add(j1);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


    }
    public  void actionPerformed(ActionEvent ae) {
        try {
            conn c = new conn();
            String str = "select gr,name, attendance from studentdata ORDER BY gr ASC";
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
        if (ae.getSource() == ADD) {
            new studdetail();
        } else if (ae.getSource() == UPDATE) {
            new addAttendance();
        }
        if (ae.getSource() == calculate) {
            t1.setVisible(false);
            d1.setVisible(false);
            d2.setVisible(false);
            d3.setVisible(false);
            add(d4);

            try {
                String str = "select gr, name , attendance from studentdata where attendance<'50'";
                conn c = new conn();
                ResultSet rs1 = c.s.executeQuery(str);
                def.setModel(DbUtils.resultSetToTableModel(rs));
                add(def);
                def.setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }



    public static void main(String[] args) {
        new attendance();

    }


}
