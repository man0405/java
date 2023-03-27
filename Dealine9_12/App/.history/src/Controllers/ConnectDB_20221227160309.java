package Controllers;

import java.sql.*;
import java.text.DecimalFormat;

import Model.User;
import View.viewMain;

public class ConnectDB {
    private viewMain v;

    public static double withTwoDecimalPlaces(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(value));
    }

    public ConnectDB(User userCurrent, int flag, int indexCurrent) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String connectionUrl = "jdbc:sqlserver://localhost;database=userDatabase;encrypt=false;integratedSecurity=false;trustServerCertificate=true;user=SA;password=Vanman@160504;";
        try {
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = con.createStatement();
            switch (flag) {
                case 1:
                    String sqlAdd = "INSERT INTO Student (Name, Address, Mark) VALUES (N'" + userCurrent.getName()
                            + "',N'" + userCurrent.getAddress() + "'," + userCurrent.getMark() + ")";
                    stmt.execute(sqlAdd);
                    break;
                case 2:
                    String sqlDelete = "DELETE FROM Student WHERE  Name = N'" + userCurrent.getName()
                            + "' and Address = N'" + userCurrent.getAddress() + "' and Mark =" + userCurrent.getMark();
                    stmt.execute(sqlDelete);
                    break;
                case 3:
                    String sqlUpdate = "Update Student set Name =N'" + userCurrent.getName() + "' , Address = N'"
                            + userCurrent.getAddress() + "' , Mark =" + userCurrent.getMark()
                            + " Where Name = (SELECT Name FROM Student ORDER BY [Order] ASC OFFSET " + indexCurrent
                            + " ROWS FETCH NEXT 1 ROW ONLY) AND Address = (SELECT Address FROM Student ORDER BY [Order] ASC OFFSET "
                            + indexCurrent
                            + " ROWS FETCH NEXT 1 ROW ONLY) AND Mark = (SELECT Mark FROM Student ORDER BY [Order] ASC OFFSET "
                            + indexCurrent + " ROWS FETCH NEXT 1 ROW ONLY);";
                    stmt.execute(sqlUpdate);
                    break;
                default:
                    String sql = "SELECT Name, Address , Mark FROM Student";
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        String name = rs.getString(1).trim();
                        String address = rs.getString(2);
                        String mark = rs.getString(3);
                        User st = new User(name, address, Double.parseDouble(mark));
                        v.addTableFromDB(st);
                    }
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
