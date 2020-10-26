package ua.delivery.model.dao.impl;

import ua.delivery.model.dao.UserDao;
import ua.delivery.model.entity.User;
import ua.delivery.model.entity.enums.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUserDao implements UserDao {

    private Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(User entity) {

        final String query = "INSERT INTO users" +
                "(firstName, lastName, username, password, role) " +
                "VALUES (?, ?, ?, ?, ?)";


        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            System.out.println("CONN");

            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getUsername());
            preparedStatement.setString(4, entity.getPassword());
            preparedStatement.setString(5, entity.getRole().name());
            preparedStatement.executeUpdate();
            System.out.println("User save");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        final String query = "SELECT * FROM users";

        try (
                Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);

            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
                users.add(user);
                System.out.println(user);
            }

//            for (User user : users) {
//                if (user.getUsername().equals(name) && user.getPassword().equals(pass)) {
//                    currentUser = user;
//                    System.out.println("currentUser: " + currentUser);
//                    HttpSession session = request.getSession();
//                    session.setAttribute("user", currentUser);

            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }

    @Override
    public User findByUsername(String username) {

        System.out.println("JDBCUserDao: findByUsername");

        final String query = "SELECT * FROM users WHERE username = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.clearParameters();
            pstmt.setString(1, username);
            ResultSet resultSet = pstmt.executeQuery();

            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
                users.add(user);
            }
            System.out.println("user: " + users);

            User currentUser = users.get(0);
            System.out.println("currentUser: " + currentUser);
            return currentUser;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

//        return null;
    }

//    @Override
//    public Optional<User> findAll(String name) {
//        return Optional.empty();
//    }
}
