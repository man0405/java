package Controllers;

import java.sql.*;
import java.text.DecimalFormat;

import Model.User;

public class ConnectDB {

    public static double withTwoDecimalPlaces(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(value));
    }
    public ConnectDB(User userCurrent , int flag, int indexCurrent) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
            String connectionUrl = "jdbc:sqlserver://localhost;database=userDatabase;encrypt=false;integratedSecurity=false;trustServerCertificate=true;user=SA;password=Vanman@160504;";
            try {
                Connection con = DriverManager.getConnection(connectionUrl);
                Statement stmt = con.createStatement();
                
                    // student st = new student(id, name, course);
                    // System.out.println(st.toString() + "");
                    switch (flag) {
                        case 1:
                            String sqlAdd = "INSERT INTO Student (Name, Address, Mark) VALUES (N'"+userCurrent.getName()+"',N'"+userCurrent.getAddress()+"',"+userCurrent.getMark()+")";
                            stmt.execute(sqlAdd);
                            break;
                        case 2:
                            String sqlDelete = "DELETE FROM Student WHERE  Name = N'"+userCurrent.getName()+"' and Address = N'"+userCurrent.getAddress()+"' and Mark ="+userCurrent.getMark();
                            stmt.execute(sqlDelete);
                            break;
                        case 3:
                            String sqlUpdate = "Update Student set Name =N'"+userCurrent.getName()+"' , Address = N'"+userCurrent.getAddress()+"' , Mark ="+userCurrent.getMark()+" Where Name = (SELECT Name FROM Student ORDER BY [Order] ASC OFFSET "+indexCurrent+" ROWS FETCH NEXT 1 ROW ONLY) AND Address = (SELECT Address FROM Student ORDER BY [Order] ASC OFFSET "+indexCurrent+" ROWS FETCH NEXT 1 ROW ONLY) AND Mark = (SELECT Mark FROM Student ORDER BY [Order] ASC OFFSET "+indexCurrent+" ROWS FETCH NEXT 1 ROW ONLY);";
                            stmt.execute(sqlUpdate);
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
