package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Ivan", "Ivanov", (byte) 12);
        userService.saveUser("Sergey", "Serov", (byte) 23);
        userService.saveUser("Petr", "Petrov", (byte) 34);
        userService.saveUser("Leo", "Duzev", (byte) 30);

        List<User> userList = userService.getAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }
        userService.removeUserById(1);
        System.out.println("after delete 1");
        List<User> userList2 = userService.getAllUsers();
        for (User user : userList2) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
