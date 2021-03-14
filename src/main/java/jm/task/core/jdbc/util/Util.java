package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/firstbd?useSSL=false";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "drakedog";
    private static Connection connection;

    public Util() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        if(connection == null){
            try {
                connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
                return connection;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }
}
