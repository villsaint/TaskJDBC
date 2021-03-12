package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    //?useSSL=false
    private static final String URL = "jdbc:mysql://localhost:3306/firstbd";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "drakedog";

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("create table users (`id` int not null AUTO_INCREMENT,`name` varchar(45) not null,`lastname` varchar(45) not null,`age` int not null,primary key (`id`)) ");
        } catch (SQLException throwables) {
        }


    }

    public void dropUsersTable() {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("drop table users");
        } catch (SQLException throwables) {
        }


    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("insert into users (name,lastName,age) values (?,?,?)")) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.execute();
            System.out.println("User с именем – " + name + " добавлен в базу данных");

        } catch (SQLException throwables) {
        }

    }

    public void removeUserById(long id) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("delete from users where id = " + (int) id);
        } catch (SQLException throwables) {
        }

    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("select * from users")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int age = resultSet.getInt(4);
                User user = new User(name, lastName, (byte) age);
                user.setId(id);
                list.add(user);
            }
        } catch (SQLException throwables) {
        }
        return list;
    }

    public void cleanUsersTable() {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("delete from users");
        } catch (SQLException throwables) {
        }

    }
}
