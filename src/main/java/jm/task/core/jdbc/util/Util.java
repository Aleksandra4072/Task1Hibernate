package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/dbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mypass";


    public static Connection getConnection() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
