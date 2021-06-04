package service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private static java.sql.Connection connection;

    private ConnectJDBC() {

    }

    private static final String URL = "jdbc:mysql://localhost:3306/manager_teaching_center";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );
                System.out.println("connect jdbc successful");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Connect JDBC false");
            } catch (ClassNotFoundException e) {
                System.out.println("Connect JDBC false");
                e.printStackTrace();
            }

        }
        return connection;
    }
}