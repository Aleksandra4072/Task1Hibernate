package jm.task.core.jdbc.dao;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connect;
    private User user = new User();

    public UserDaoJDBCImpl() {
        connect = Util.getConnection();
    }

    public void createUsersTable() {
        final String sqlCommand = "CREATE TABLE IF NOT EXISTS users ("
                + "id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL, "
                + "name VARCHAR(30) NOT NULL, lastName VARCHAR(30) NOT NULL, "
                + "age INT NOT NULL)";
        try (Statement s = connect.createStatement()) {
            s.executeUpdate(sqlCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        final String sqlCommand = "DROP TABLE IF EXISTS users";
        try (Statement s = connect.createStatement()) {
            s.executeUpdate(sqlCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        final String sqlCommand = "INSERT INTO users(name, lastName, age) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connect.prepareStatement(sqlCommand)) {
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        user.setId(id);
        final String sqlCommand = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement ps = connect.prepareStatement(sqlCommand)) {
            ps.setLong(1, user.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        final String sqlCommand = "SELECT * FROM users";
        ArrayList<User> result = new ArrayList();
        try (Statement s = connect.createStatement()) {
            ResultSet rs = s.executeQuery(sqlCommand);
            while (rs.next()) {
                user.setId(rs.getLong(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setAge(rs.getByte(4));
                result.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void cleanUsersTable() {
        final String sql = "DELETE FROM users";
        try (Statement s = connect.createStatement()) {
            s.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
