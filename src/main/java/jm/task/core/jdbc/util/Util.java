package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private  final String URL = "jdbc:mysql://localhost:3306/firstbd?useSSL=false";
    private  final String LOGIN = "root";
    private  final String PASSWORD = "drakedog";
    private  final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Util instance;
    private  Connection connection;


    private Util() {
    }

    public static Util getInstance(){
        if(instance == null){
            instance = new Util();
        }
        return instance;
    }

    public  Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
                return connection;
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }
}
