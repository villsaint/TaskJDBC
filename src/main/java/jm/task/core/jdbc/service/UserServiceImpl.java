package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDaou = new UserDaoJDBCImpl();

    public void createUsersTable() {
        userDaou.createUsersTable();

    }

    public void dropUsersTable() {
        userDaou.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        userDaou.saveUser(name, lastName, age);

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
