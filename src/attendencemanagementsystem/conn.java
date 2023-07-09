package attendencemanagementsystem;

import java.sql.*;
public class conn{
    Connection c;
    Statement s;
     conn(){
         String url = "jdbc:mysql://localhost:3306/ams";
         String username = "root";
         String password = "Siddhesh@25";

         try {
             c = DriverManager.getConnection(url,username,password);
             s = c.createStatement();
             System.out.println("connection successful");
         }catch (Exception e){
             System.out.println(e);
         }
     }

    public static void main(String[] args) {
        new conn();

    }
}
