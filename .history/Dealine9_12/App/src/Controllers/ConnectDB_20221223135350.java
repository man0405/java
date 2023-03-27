package Controllers;

import java.sql.*;
import java.text.DecimalFormat;

import Model.User;

public class ConnectDB {

    public static double withTwoDecimalPlaces(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        return new Double(df.format(value));
    }
    public static void main(String[] args) {
        
    
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
            String connectionUrl = "jdbc:sqlserver://localhost;database=userDatabase;encrypt=false;integratedSecurity=false;trustServerCertificate=true;user=SA;password=Vanman@160504;";
            try {
                Connection con = DriverManager.getConnection(connectionUrl);
                Statement stmt = con.createStatement();
                String sql = "SELECT * FROM Student";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String Name = rs.getString(1).trim();
                    String Address = rs.getString(2);
                    Float Mark = rs.getFloat(3);
                    
                    User user = new User(Name, Address, withTwoDecimalPlaces(Mark));
                    System.out.println(user.toString());
                    // student st = new student(id, name, course);
                    // System.out.println(st.toString() + "");
    
                }
                rs.close();
                stmt.close();
                con.close();
    
            } catch (Exception e) {
                System.out.println();
                e.printStackTrace();
            }
    }
}
