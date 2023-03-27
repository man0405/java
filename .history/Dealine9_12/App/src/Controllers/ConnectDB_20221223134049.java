package Controllers;

import java.sql.*;

import Model.User;

public class ConnectDB {
    public static void main(String[] args) {
        
    
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
            String connectionUrl = "jdbc:sqlserver://localhost;database=StudentDB2022;encrypt=false;integratedSecurity=false;trustServerCertificate=true;user=SA;password=Vanman@160504;";
            try {
                Connection con = DriverManager.getConnection(connectionUrl);
                Statement stmt = con.createStatement();
                String sql = "SELECT * FROM Student";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String Name = rs.getString(1).trim();
                    String Address = rs.getString(2);
                    String Mark = rs.getString(3);
                    
                    User user = new User(Name, Address, Double.parseDouble(Mark));
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
