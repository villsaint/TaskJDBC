package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDaou = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userDaou.createUsersTable();
    }

    public void dropUsersTable() {
        userDaou.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaou.saveUser(name, lastName, age);
        System.out.println("User с именем – " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        userDaou.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaou.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaou.cleanUsersTable();
    }
}
