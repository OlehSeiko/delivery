package ua.delivery.model.dao.impl;

import ua.delivery.model.Util;
import ua.delivery.model.dao.DaoFactory;
import ua.delivery.model.dao.UserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {


    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    private Connection getConnection() {
        try {
//            return dataSource.getConnection();
            String url = new Util().getPropertyValue("url");
            String username = new Util().getPropertyValue("username");
            String password = new Util().getPropertyValue("password");

            return DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
