//package ua.delivery.model.dao.impl;
//
//import org.apache.commons.dbcp.BasicDataSource;
//import ua.delivery.model.dao.UserDAO;
//import ua.delivery.model.entity.User;
//import ua.delivery.model.entity.enums.Role;
//
//import javax.sql.DataSource;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class JDBCUserDao implements UserDAO {
//
//    private Connection connection;
//
//    public JDBCUserDao(Connection connection) {
//        this.connection = connection;
//    }
//
//
//    @Override
//    public void create(User entity) {
//
//        final String query = "INSERT INTO users" +
//                "(firstName, lastName, username, password, role) " +
//                "VALUES (?, ?, ?, ?, ?)";
//
////        DataSource dataSource;
////        BasicDataSource ds = new BasicDataSource();
////        ds.setUrl(url);
////        ds.setUsername(username1);
////        ds.setPassword(password1);
////        ds.setMinIdle(5);
////        ds.setMaxIdle(10);
////        ds.setMaxOpenPreparedStatements(100);
////        dataSource = ds;
////
//        try
//        {
//            System.out.println("CONN");
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, entity.getFirstName());
//            preparedStatement.setString(2, entity.getLastName());
//            preparedStatement.setString(3, entity.getUsername());
//            preparedStatement.setString(4, entity.getPassword());
//            preparedStatement.setString(5, entity.getRole().name());
//            preparedStatement.executeUpdate();
//            System.out.println("User save");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public User findById(int id) {
//        return null;
//    }
//
//    @Override
//    public List<User> findAll() {
//        final String query = "SELECT * FROM user";
//
//        try (Statement stmt = connection.createStatement()) {
//            ResultSet resultSet = stmt.executeQuery(query);
//
//            List<User> users = new ArrayList<>();
//
//            while (resultSet.next()){
//                User user = new User();
//                user.setId(resultSet.getInt("id"));
//                user.setFirstName(resultSet.getString("firstName"));
//                user.setLastName(resultSet.getString("lastName"));
//                user.setRole(Role.valueOf(resultSet.getString("role")));
//                user.setUsername(resultSet.getString("username"));
//                user.setPassword(resultSet.getString("password"));
//                users.add(user);
//            }
//
//            System.out.println("users:\n"+users);
//            return users;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public void update(User entity) {
//
//    }
//
//    @Override
//    public void delete(int id) {
//
//    }
//
//    @Override
//    public void close() {
//
//    }
//}
