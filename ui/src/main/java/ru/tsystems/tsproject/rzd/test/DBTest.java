package ru.tsystems.tsproject.rzd.test;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: herr
 * Date: 30.09.14
 * Time: 21:24
 * To change this template use File | Settings | File Templates.
 */
public class DBTest {

    public static void main(String[] args) {
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "12345");

            Statement statementData = connection.createStatement();
            ResultSet resultData = statementData.executeQuery("select * from test_table where test_field = 1");

            while (resultData.next()) {
                String value = resultData.getString("test_field_char");
                System.out.println("Success! Result value is " + value);
            }
        } catch (SQLException e) {
            System.out.println("Fail!" + e);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver problem!" + e);
            e.printStackTrace();
        }
    }
}
