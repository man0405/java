package Controllers;

import java.sql.*;
import java.text.DecimalFormat;

import Model.User;

public class ConnectDB {

    public static double withTwoDecimalPlaces(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(value));
    }
    public ConnectDB(User userCurrent , int flag) {
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
                
                    // student st = new student(id, name, course);
                    // System.out.println(st.toString() + "");
                    switch (flag) {
                        case 1:
                            String sqlAdd = "INSERT INTO Student (Name, Address, Mark) VALUES (N'"+userCurrent.getName()+"',N'"+userCurrent.getAddress()+"',"+userCurrent.getMark()+")";
                            stmt.execute(sqlAdd);
                            break;
                    
                        default:
                            break;
                    }
    
                
                // rs.close();
                stmt.close();
                con.close();
    
            } catch (Exception e) {
                System.out.println();
                e.printStackTrace();
            }
    }
}
