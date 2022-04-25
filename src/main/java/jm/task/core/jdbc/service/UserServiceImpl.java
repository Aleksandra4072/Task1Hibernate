package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateIMPL;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDaoHibernateIMPL = new UserDaoHibernateIMPL();

    public void createUsersTable() {
        userDaoHibernateIMPL.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoHibernateIMPL.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernateIMPL.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoHibernateIMPL.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoHibernateIMPL.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoHibernateIMPL.cleanUsersTable();
    }
}
