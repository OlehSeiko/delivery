package ua.delivery.controller.command;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.delivery.controller.Command;
import ua.delivery.model.entity.User;
import ua.delivery.model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Login implements Command {

    private static final Logger logger = LogManager.getLogger(Login.class);

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        request.setAttribute("username", name);
        System.out.println(name + " " + pass);
        User currentUser = new User();
        if (name == null || name.equals(" ") || pass == null || pass.equals(" ")) {
            return "/login.jsp";
        } else {
            String url = "jdbc:mysql://localhost:3306/userdb?useUnicode=true&serverTimezone=UTC";
            String username1 = "root";
            String password1 = "root";

//            final String query = "INSERT INTO users" +
//                    "(firstName, lastName, username, password, role) " +
//                    "VALUES (?, ?, ?, ?, ?)";

            DataSource dataSource;
            BasicDataSource ds = new BasicDataSource();
            ds.setUrl(url);
            ds.setUsername(username1);
            ds.setPassword(password1);
            ds.setMinIdle(5);
            ds.setMaxIdle(10);
            ds.setMaxOpenPreparedStatements(100);
            dataSource = ds;

            final String query = "SELECT * FROM users";

            try (Connection conn = dataSource.getConnection();
                 Statement stmt = conn.createStatement()) {
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

                for (User user : users) {
                    if (user.getUsername().equals(name) && user.getPassword().equals(pass)) {
                        currentUser = user;
                        System.out.println("currentUser: " + currentUser);
                        HttpSession session = request.getSession();
                        session.setAttribute("user", currentUser);

                        return "redirect:/user-basis";
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }


            return "redirect:/login.jsp";
        }



    }
}




