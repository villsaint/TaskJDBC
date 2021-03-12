package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;


import java.util.List;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/firstbd?useSSL=false";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "drakedog";

    public static void main(String[] args) {
        driverReg();
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.saveUser("Ivan", "Ivanov", (byte) 12);
        userDao.saveUser("Sergey", "Serov", (byte) 23);
        userDao.saveUser("Petr", "Petrov", (byte) 34);
        userDao.saveUser("Leo", "Duzev", (byte) 30);

        List<User> userList = userDao.getAllUsers();

        for (User u : userList) {
            System.out.println(u);
        }

        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }

    private static void driverReg() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
